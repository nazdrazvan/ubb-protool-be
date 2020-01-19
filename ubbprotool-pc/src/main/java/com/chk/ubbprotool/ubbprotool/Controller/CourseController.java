package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.Service.CourseService;
import com.chk.ubbprotool.ubbprotool.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public ResponseEntity<List<CourseDTO>> listCourses() {
        return  ResponseEntity.ok(courseService.findAllCourses());
    }


    @PostMapping("/saveCourse")
    public ResponseEntity<String> saveCourse(@RequestBody CourseDTO theCourse) throws IOException {
        courseService.createCourse(theCourse);
        return ResponseEntity.ok("Course saved");
    }

    @PostMapping("/deleteCourse/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok("Course deleted");
    }

    @PostMapping("/updateCourse")
    public ResponseEntity<String> updateCourse(@RequestBody CourseDTO theCourse) throws IOException {
        courseService.upgradeCourse(theCourse);
        return ResponseEntity.ok("Course updated");
    }

    @GetMapping("/get-by-id/{courseId}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("courseId") Long courseId) throws IOException {
        return new ResponseEntity<>(courseService.findById(courseId), HttpStatus.OK);
    }

}
