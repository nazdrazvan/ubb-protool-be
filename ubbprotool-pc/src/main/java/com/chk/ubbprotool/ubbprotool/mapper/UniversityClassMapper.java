package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.dto.UniversityClassDTO;
import com.chk.ubbprotool.ubbprotool.Model.Course;
import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import org.springframework.stereotype.Component;

@Component
public class UniversityClassMapper {

    public UniversityClass toEntity(UniversityClassDTO universityClassDTO)
    {
        UniversityClass result = new UniversityClass();

        result.setSubgroup(universityClassDTO.getSubgroup());
        result.setClassDay(universityClassDTO.getClassDay());
        result.setClassDuration(universityClassDTO.getClassDuration());
        result.setClassHour(universityClassDTO.getClassHour());
        result.setClassLocation(universityClassDTO.getClassLocation());
        result.setClassType(universityClassDTO.getClassType());
        result.setClassWeek(universityClassDTO.getClassWeek());
        result.setCourse(universityClassDTO.getCourse());
        result.setTeacher(universityClassDTO.getTeacher());

        return result;

    }

    public UniversityClassDTO toDTO(UniversityClass universityClass)
    {
        UniversityClassDTO result = new UniversityClassDTO();

        result.setSubgroup(universityClass.getSubgroup());
        result.setClassDay(universityClass.getClassDay());
        result.setClassDuration(universityClass.getClassDuration());
        result.setClassHour(universityClass.getClassHour());
        result.setClassLocation(universityClass.getClassLocation());
        result.setClassType(universityClass.getClassType());
        result.setClassWeek(universityClass.getClassWeek());
        result.setCourse(universityClass.getCourse());
        result.setTeacher(universityClass.getTeacher());

        return result;
    }

}
