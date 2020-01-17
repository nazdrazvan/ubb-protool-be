package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Course;
import com.chk.ubbprotool.ubbprotool.Repository.CourseRepository;
import com.chk.ubbprotool.ubbprotool.dto.CourseDTO;
import com.chk.ubbprotool.ubbprotool.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan(basePackages = "com.chk.ubbprotool.ubbprotool")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void createCourse(CourseDTO course) {
        courseRepository.saveData(courseMapper.toEntity(course));
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepository.removeData(courseId);
    }

    @Override
    public void upgradeCourse(CourseDTO course) {
        courseRepository.saveData(courseMapper.toEntity(course));
    }

    @Override
    public List<CourseDTO> findAllCourses() {
        List<CourseDTO> courseDTOList = new ArrayList<CourseDTO>();

        for (Course course : courseRepository.findAll() )
        {
            CourseDTO courseDTO = courseMapper.toDTO(course) ;
            courseDTOList.add(courseDTO);
        }

        return courseDTOList;
    }

    @Override
    public CourseDTO findById(int id) {
        return courseMapper.toDTO(courseRepository.findById(id));
    }
}
