package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void createStudent(StudentDTO student) {
        Student stud = studentMapper.map(student,stud);
        studentRepository.save(stud);
    }

    @Override
    public void deleteStudent(int studentId) {
     studentRepository.deleteById(studentId);
    }

    @Override
    public void upgradeStudent(StudentDTO student) {
        Student stud = studentMapper.map(student,stud);
        studentRepository.save(stud);
    }

    @Override
    public List<StudentDTO> findAllStudents() {
        List<Student> students =  studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();

        for (Student stud : students )
        {
            StudentDTO studDTO = studentMapper.map(stud , stud) ;
            studentDTOList.add(studDTO);
        }

        return studentDTOList;
    }

    @Override
    public StudentDTO findById(int id) {
        return studentRepository.findById(id);
    }
}
