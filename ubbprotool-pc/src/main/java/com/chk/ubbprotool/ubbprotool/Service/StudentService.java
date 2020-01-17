package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

     void createStudent(StudentDTO student );

     void deleteStudent(int studentId);

     void upgradeStudent(StudentDTO student);

     List<StudentDTO> findAllStudents();

     StudentDTO findById(int id);


}
