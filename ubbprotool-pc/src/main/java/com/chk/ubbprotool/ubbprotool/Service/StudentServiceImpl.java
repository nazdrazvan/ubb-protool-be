package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Repository.SubgroupRepository;
import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Repository.StudentRepository;
import com.chk.ubbprotool.ubbprotool.dto.StudentForRegisterDTO;
import com.chk.ubbprotool.ubbprotool.dto.StudentForEditDTO;
import com.chk.ubbprotool.ubbprotool.mapper.StudentForRegisterMapper;
import com.chk.ubbprotool.ubbprotool.mapper.StudentForEditMapper;
import com.chk.ubbprotool.ubbprotool.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan(basePackages = "com.chk.ubbprotool.ubbprotool")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubgroupRepository subgroupRepository;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentForRegisterMapper studentforRegisterMapper;
    @Autowired
    private StudentForEditMapper studentForEditMapper;

    @Override
    @Transactional
    public void createStudent(StudentForRegisterDTO student) throws Exception {
        Student stud = studentforRegisterMapper.toEntity(student);
        if (stud.getSubgroup() == null)
            throw new Exception("The group does not exist!");
        studentRepository.saveData(stud);
    }

    @Override
    @Transactional
    public void deleteStudent(Long studentId) {
        studentRepository.removeData(studentId);
    }

    @Override
    @Transactional
    public void updateStudent(StudentForEditDTO student) throws Exception {
        if (subgroupRepository.findByGroupAndSubgroup(student.getStudentGroup(), student.getStudentSubGroup()) == null)
            throw new Exception("The group does not exist!");
        Student stud = studentForEditMapper.toEntity(student);
        studentRepository.updateData(stud);
    }

    @Override
    @Transactional
    public List<StudentDTO> findAllStudents() {
        //List<Student> students =  studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();

        for (Student stud : studentRepository.findAll()) {
            StudentDTO studDTO = studentMapper.toDTO(stud);
            studentDTOList.add(studDTO);
        }

        return studentDTOList;
    }

    @Override
    @Transactional
    public StudentDTO findById(Long id) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            return null;
        }
        return studentMapper.toDTO(student);
    }

    @Override
    @Transactional
    public StudentForRegisterDTO findStudentByEmailAndPassword(String email, String password) {
        Student student = studentRepository.findByEmailAndPassword(email, password);
        if (student == null) {
            return null;
        }
        return studentforRegisterMapper.toDTO(student);
    }

    @Override
    @Transactional
    public boolean checkIfStudentDoesNotExists(String email) throws Exception {
        Student student = studentRepository.findByEmail(email);
        if (student == null) {
            return true;
        }
        throw new Exception("The student already has an account!");
    }
}
