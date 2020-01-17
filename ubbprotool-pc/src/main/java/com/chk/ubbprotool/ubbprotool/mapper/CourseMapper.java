package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.dto.CourseDTO;
import com.chk.ubbprotool.ubbprotool.Model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course source)
    {
        CourseDTO result = new CourseDTO();

        result.setCourseId(source.getCourseId());
        result.setCourseEndDate(source.getCourseEndDate());
        result.setCourseFaculty(source.getCourseFaculty());
        result.setCourseName(source.getCourseName());
        result.setCourseSemester(source.getCourseSemester());
        result.setCourseStartDate(source.getCourseStartDate());
        result.setCourseUniversity(source.getCourseUniversity());

        return result;
    }

    public Course toEntity(CourseDTO source)
    {
        Course result = new Course();

        result.setCourseId(source.getCourseId());
        result.setCourseEndDate(source.getCourseEndDate());
        result.setCourseFaculty(source.getCourseFaculty());
        result.setCourseName(source.getCourseName());
        result.setCourseSemester(source.getCourseSemester());
        result.setCourseStartDate(source.getCourseStartDate());
        result.setCourseUniversity(source.getCourseUniversity());

        return result;
    }
}

