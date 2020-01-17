package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    void createCourse(CourseDTO course );

    void deleteCourse(int courseId);

    void upgradeCourse(CourseDTO course);

    List<CourseDTO> findAllCourses();

    CourseDTO findById(int id);

}
