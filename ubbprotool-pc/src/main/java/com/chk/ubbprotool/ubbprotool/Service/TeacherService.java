package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import com.chk.ubbprotool.ubbprotool.dto.TeacherDTO;
import com.chk.ubbprotool.ubbprotool.dto.TeacherForEditDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    void createTeacher(TeacherDTO teacher);

    void deleteTeacher(Long teacherId);

    void editTeacher(TeacherForEditDTO teacher);

    List<TeacherDTO> findAllTeachers();

    TeacherDTO findById(Long id);

    TeacherDTO findTeacherByEmailAndPassword(String email, String password);

    void activateTeacher(TeacherDTO teacher) throws Exception;

}
