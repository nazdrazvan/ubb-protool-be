package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.dto.StudentForRegisterDTO;
import com.chk.ubbprotool.ubbprotool.dto.TeacherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

     void createStudent(StudentForRegisterDTO student) throws Exception;

     void deleteStudent(Long studentId);

     void upgradeStudent(StudentDTO student);

     List<StudentDTO> findAllStudents();

     StudentDTO findById(Long id);

     StudentDTO findStudentByEmailAndPassword(String email, String password);

}
