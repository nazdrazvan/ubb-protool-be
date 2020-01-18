package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import com.chk.ubbprotool.ubbprotool.Repository.StudentRepository;
import com.chk.ubbprotool.ubbprotool.Repository.SubgroupRepository;
import com.chk.ubbprotool.ubbprotool.Repository.UniversityClassRepository;
import com.chk.ubbprotool.ubbprotool.Repository.WeeksRepository;
import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.dto.SubgroupDTO;
import com.chk.ubbprotool.ubbprotool.dto.UniversityClassDTO;
import com.chk.ubbprotool.ubbprotool.mapper.StudentMapper;
import com.chk.ubbprotool.ubbprotool.mapper.UniversityClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@ComponentScan(basePackages = "com.chk.ubbprotool.ubbprotool")
public class UniversityClassServiceImpl implements UniversityClassService{

    @Autowired
    private UniversityClassRepository universityClassRepository;

    @Autowired
    private StudentRepository studentRepository;

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
    public UniversityClassDTO findById(int id) {
        UniversityClass universityClass = universityClassRepository.findById(id);
        return universityClassMapper.toDTO(universityClass);
    }

    @Override
    @Transactional
    public List<UniversityClassDTO> getClassesForStudent(int studentId, Date date) {

        Student student = studentRepository.findById(studentId);

        Subgroup studentSubgroup = subgroupRepository.findById(student.getSubgroup().getSubgroupId());

        List<UniversityClass> classes = studentSubgroup.getClasses();

        List<UniversityClassDTO> dtoList = new ArrayList<>();

        for (UniversityClass clasa : classes)
        {
            int currentWeek = weeksRepository.findByDate(date);

            if(clasa.getClassWeek() == 0 || clasa.getClassWeek() == currentWeek % 2)
            dtoList.add(universityClassMapper.toDTO(clasa));


        }

        return dtoList;
    }

    @Override
    @Transactional
    public List<StudentDTO> findAllStudentsByClassId(int classId){
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
}
