package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.dto.StudentForRegisterDTO;
import com.chk.ubbprotool.ubbprotool.dto.StudentForEditDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

     void createStudent(StudentForRegisterDTO student) throws Exception;

     void deleteStudent(Long studentId);

     void updateStudent(StudentForEditDTO student) throws Exception;

     List<StudentDTO> findAllStudents();

     StudentDTO findById(Long id);

     StudentForRegisterDTO findStudentByEmailAndPassword(String email, String password);

     boolean checkIfStudentDoesNotExists(String email) throws Exception;
}
