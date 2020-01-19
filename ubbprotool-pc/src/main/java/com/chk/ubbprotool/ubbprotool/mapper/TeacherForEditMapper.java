package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import com.chk.ubbprotool.ubbprotool.Repository.TeacherRepository;
import com.chk.ubbprotool.ubbprotool.dto.StudentForEditDTO;
import com.chk.ubbprotool.ubbprotool.dto.TeacherForEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherForEditMapper {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher toEntity(TeacherForEditDTO teach) {
        Teacher teacher = teacherRepository.findById(teach.getTeacherId());
        teacher.setTeacherFirstName(teach.getTeacherFirstName());
        teacher.setTeacherLastName(teach.getTeacherLastName());
        teacher.setTeacherWebSite(teach.getTeacherWebSite());
        teacher.setTeacherAvailability(teach.getTeacherAvailability());
        return teacher;
    }
}
