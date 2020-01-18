package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Course;
import com.chk.ubbprotool.ubbprotool.Repository.CourseRepository;
import com.chk.ubbprotool.ubbprotool.dto.CourseDTO;
import com.chk.ubbprotool.ubbprotool.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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
    @Transactional
    public void createCourse(CourseDTO course) {
        courseRepository.saveData(courseMapper.toEntity(course));
    }

    @Override
    @Transactional
    public void deleteCourse(Long courseId) {
        courseRepository.removeData(courseId);
    }

    @Override
    @Transactional
    public void upgradeCourse(CourseDTO course) {
        courseRepository.updateData(courseMapper.toEntity(course));
    }

    @Override
    @Transactional
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
    @Transactional
    public CourseDTO findById(Long id) {
        Course course = courseRepository.findById(id);
        if (course == null) {
            return null;
        }
        return courseMapper.toDTO(course);
    }

}
