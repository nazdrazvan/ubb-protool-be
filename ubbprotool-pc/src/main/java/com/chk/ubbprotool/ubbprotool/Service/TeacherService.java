package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import com.chk.ubbprotool.ubbprotool.dto.TeacherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    void createTeacher(TeacherDTO teacher );

    void deleteTeacher(int teacherId);

    void upgradeTeacher(TeacherDTO teacher);

    List<TeacherDTO> findAllTeachers();

    TeacherDTO findById(int id);

    TeacherDTO findTeacherByEmailAndPassword(String email, String password);

}
