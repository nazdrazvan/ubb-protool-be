package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.DTO.StudentDTO;
import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Repository.StudentRepository;
import com.chk.ubbprotool.ubbprotool.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@ComponentScan(basePackages = "com.chk.ubbprotool.ubbprotool")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional
    public void createStudent(StudentDTO student) {
        Student stud = studentMapper.toEntity(student);
        studentRepository.saveData(stud);
    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {
     studentRepository.removeData(studentId);
    }

    @Override
    @Transactional
    public void upgradeStudent(StudentDTO student) {
        Student stud = studentMapper.toEntity(student);
        studentRepository.saveData(stud);
    }

    @Override
    @Transactional
    public List<StudentDTO> findAllStudents() {
        //List<Student> students =  studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();

        for (Student stud : studentRepository.findAll() )
        {
            StudentDTO studDTO = studentMapper.toDTO(stud) ;
            studentDTOList.add(studDTO);
        }

        return studentDTOList;
    }

    @Override
    @Transactional
    public StudentDTO findById(int id) {
        Student student = studentRepository.findById(id);
        return studentMapper.toDTO(student);


    }
}