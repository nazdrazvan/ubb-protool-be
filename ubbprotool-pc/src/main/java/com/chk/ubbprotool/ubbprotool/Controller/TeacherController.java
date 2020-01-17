package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.Service.TeacherService;
import com.chk.ubbprotool.ubbprotool.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/deleteTeacher")
    public ResponseEntity<String> deleteTeacher(@RequestParam("TeacherId") int theId) {
        teacherService.deleteTeacher(theId);
        return ResponseEntity.ok("Teacher deleted");
    }

    @PostMapping("/updateTeacher")
    public ResponseEntity<String> updateTeacher(@RequestBody TeacherDTO theTeacher) throws IOException {
        teacherService.upgradeTeacher(theTeacher);
        return ResponseEntity.ok("Teacher updated");
    }

}
