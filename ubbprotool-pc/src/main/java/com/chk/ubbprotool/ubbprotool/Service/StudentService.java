package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

     void createStudent(StudentDTO student );

     void deleteStudent(int studentId);

     void upgradeStudent(StudentDTO student);

     List<StudentDTO> findAllStudents();

     StudentDTO findById(int id);


}
