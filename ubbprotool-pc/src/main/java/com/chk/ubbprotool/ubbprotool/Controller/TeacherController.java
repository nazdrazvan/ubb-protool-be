package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.Service.TeacherService;
import com.chk.ubbprotool.ubbprotool.dto.TeacherDTO;
import com.chk.ubbprotool.ubbprotool.dto.TeacherForEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/list")
    public ResponseEntity<List<TeacherDTO>> listTeachers() {
        return  ResponseEntity.ok(teacherService.findAllTeachers());
    }

    @PostMapping("/saveTeacher")
    public ResponseEntity<String> saveTeacher(@RequestBody TeacherDTO theTeacher) throws IOException {
        teacherService.createTeacher(theTeacher);
        return ResponseEntity.ok("Teacher saved");
    }

    @PostMapping("/activateTeacher")
    public ResponseEntity<String> activateTeacher(@RequestBody TeacherDTO teacher) throws Exception {
        teacherService.activateTeacher(teacher);
        return ResponseEntity.ok("Teacher activated");
    }

    @PostMapping("/deleteTeacher/{teacherId}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok("Teacher deleted");
    }

    @PostMapping("/updateTeacher")
    public ResponseEntity<String> updateTeacher(@RequestBody TeacherForEditDTO theTeacher) throws IOException {
        teacherService.editTeacher(theTeacher);
        return ResponseEntity.ok("Teacher updated");
    }

    @GetMapping("/get-by-id/{teacherId}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable("teacherId") Long teacherId) {
        return new ResponseEntity<>(teacherService.findById(teacherId), HttpStatus.OK);
    }
}
