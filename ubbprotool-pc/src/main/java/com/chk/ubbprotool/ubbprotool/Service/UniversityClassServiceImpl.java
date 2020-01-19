package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import com.chk.ubbprotool.ubbprotool.Repository.*;
import com.chk.ubbprotool.ubbprotool.dto.ChangeDTO;
import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.Repository.StudentRepository;
import com.chk.ubbprotool.ubbprotool.Repository.SubgroupRepository;
import com.chk.ubbprotool.ubbprotool.Repository.UniversityClassRepository;
import com.chk.ubbprotool.ubbprotool.Repository.WeeksRepository;
import com.chk.ubbprotool.ubbprotool.dto.UniversityClassDTO;
import com.chk.ubbprotool.ubbprotool.mapper.StudentMapper;
import com.chk.ubbprotool.ubbprotool.mapper.UniversityClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan(basePackages = "com.chk.ubbprotool.ubbprotool")
public class UniversityClassServiceImpl implements UniversityClassService{

    @Autowired
    private UniversityClassRepository universityClassRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubgroupRepository subgroupRepository;

    @Autowired
    private UniversityClassMapper universityClassMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private WeeksRepository weeksRepository;


    @Override
    @Transactional
    public void createUniversityClass(UniversityClassDTO universityClassDTO) {
        UniversityClass univ = universityClassMapper.toEntity(universityClassDTO);
        universityClassRepository.saveData(univ);
    }

    @Override
    @Transactional
    public void deleteUniversityClass(int universityClassId) {
        universityClassRepository.removeData(universityClassId);
    }

    @Override
    @Transactional
    public void updateUniversityClass(UniversityClassDTO universityClassDTO) {
        UniversityClass univ = universityClassMapper.toEntity(universityClassDTO);
        universityClassRepository.updateData(univ);
    }

    @Override
    @Transactional
    public List<UniversityClassDTO> findAllUniversityClasses() {
        List<UniversityClassDTO> univDtoList = new ArrayList<UniversityClassDTO>();
        for (UniversityClass univ : universityClassRepository.findAll() )
        {
            UniversityClassDTO universityClassDTO = universityClassMapper.toDTO(univ) ;
            univDtoList.add(universityClassDTO);
        }
        return univDtoList;
    }

    @Override
    @Transactional
    public UniversityClassDTO findById(Long id) {
        UniversityClass universityClass = universityClassRepository.findById(id);
        if (universityClass == null) {
            return null;
        }
        return universityClassMapper.toDTO(universityClass);
    }

    @Override
    @Transactional
    public List<UniversityClassDTO> getClassesForStudent(Long studentId, Date date, List<ChangeDTO> changes) throws Exception {

        Student student = studentRepository.findById(studentId);
        if(student == null)
            throw new Exception("Student doesn't exist!");

        Subgroup studentSubgroup = subgroupRepository.findById(student.getSubgroup().getSubgroupId());

        List<UniversityClass> classes = studentSubgroup.getClasses();

        List<UniversityClassDTO> classesDto = new ArrayList<>();


        for (UniversityClass clasa : classes)
        {
            int currentWeek = weeksRepository.findByDate(date);

            if(clasa.getClassWeek() == 0 || clasa.getClassWeek()%2 == currentWeek % 2)
                classesDto.add(universityClassMapper.toDTO(clasa));
        }

        for(ChangeDTO change: changes) {
            if(change.getEndDate().compareTo(date) >= 0 && change.getChangeStatus().equals("accepted"))
            {
                UniversityClassDTO new_class = this.findById(change.getUniversityClassId());
                for(UniversityClassDTO clasa: classesDto)
                {
                    if(clasa.getCourseId() == new_class.getCourseId() && clasa.getClassType().equals(new_class.getClassType()))
                    {
                        classesDto.remove(clasa);
                        classesDto.add(new_class);
                    }
                }
            }
        }

        return classesDto;
    }

    @Override
    @Transactional
    public List<UniversityClassDTO> getClassesForTeacher(Long teacherId, Date date) {

        Teacher teacher = teacherRepository.findById(teacherId);

        List<UniversityClass> classes = teacher.getClasses();

        List<UniversityClassDTO> dtoList = new ArrayList<>();

        for (UniversityClass clasa : classes)
        {
            int currentWeek = weeksRepository.findByDate(date);

            if(clasa.getClassWeek() == 0 || clasa.getClassWeek()%2 == currentWeek % 2)
                dtoList.add(universityClassMapper.toDTO(clasa));
        }
        return dtoList;
    }

    @Override
    @Transactional
    public List<StudentDTO> findAllStudentsByClassId(Long classId){
        List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();

        UniversityClass universityClass = universityClassRepository.findById(classId);
        Subgroup subgroup = universityClass.getSubgroup();
        List<Student> students = subgroup.getStudents();

        for (Student student : students) {
            StudentDTO studentDTO = studentMapper.toDTO(student);
            studentDTOList.add(studentDTO);
        }
        if(studentDTOList.size()==0){return null;}
        return studentDTOList;
    }


    @Override
    @Transactional
    public List<UniversityClassDTO> getPossibleClassesToBeChanged(Long classId, Date currentDate) {
        List<UniversityClassDTO> classes = new ArrayList<>();

        String type = this.findById(classId).getClassType();
        Long courseId = this.findById(classId).getCourseId();
        int currentWeek = weeksRepository.findByDate(currentDate);
        int week = 0;
        if(currentWeek % 2 == 0)
        {
            week = 2;
        }
        else if(currentWeek % 2 == 1) {
            week = 1;
        }

        if(week == 2)
        {
            for(UniversityClassDTO clasa: this.findAllUniversityClasses())
            {
                if(clasa.getClassType().equals(type) && clasa.getCourseId() == courseId && (clasa.getClassWeek() == 2 || clasa.getClassWeek() == 0) && clasa.getClassId() != classId)
                    classes.add(clasa);
            }
        }
        else if(week == 1){
            for(UniversityClassDTO clasa: this.findAllUniversityClasses())
            {
                if(clasa.getClassType().equals(type) && clasa.getCourseId() == courseId && clasa.getClassId() != classId)
                    classes.add(clasa);
            }
        }

        return classes;
    }
}
