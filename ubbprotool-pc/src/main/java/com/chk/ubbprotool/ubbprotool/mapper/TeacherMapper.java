package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.dto.TeacherDTO;
import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public TeacherDTO toDTO(Teacher source)
    {
        TeacherDTO result = new TeacherDTO();

        result.setTeacherId(source.getTeacherId());
        result.setTeacherAvailability(source.isTeacherAvailability());
        result.setTeacherDepartment(source.getTeacherDepartment());
        result.setEmail(source.getEmail());
        result.setTeacherEnabled(source.isTeacherEnabled());
        result.setTeacherFaculty(source.getTeacherFaculty());
        result.setTeacherFirstName(source.getTeacherFirstName());
        result.setTeacherLastName(source.getTeacherLastName());
        result.setPassword(source.getPassword());
        result.setTeacherUniversity(source.getTeacherUniversity());
        result.setTeacherWebSite(source.getTeacherWebSite());


        return result;
    }

    public Teacher toEntity(TeacherDTO source)
    {
        Teacher result = new Teacher();

        result.setTeacherId(source.getTeacherId());
        result.setTeacherAvailability(source.isTeacherAvailability());
        result.setTeacherDepartment(source.getTeacherDepartment());
        result.setEmail(source.getEmail());
        result.setTeacherEnabled(source.isTeacherEnabled());
        result.setTeacherFaculty(source.getTeacherFaculty());
        result.setTeacherFirstName(source.getTeacherFirstName());
        result.setTeacherLastName(source.getTeacherLastName());
        result.setPassword(source.getPassword());
        result.setTeacherUniversity(source.getTeacherUniversity());
        result.setTeacherWebSite(source.getTeacherWebSite());


        return result;
    }

}
