package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<List<StudentDTO>> listUsers() {
        return  ResponseEntity.ok(studentService.findAllStudents());
    }


    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveUser(@RequestBody StudentDTO theStudent) throws IOException {
        studentService.saveUser(theStudent);
        return ResponseEntity.ok("Student saved");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam("UserId") int theId) {
        studentService.removeUser(theId);
        return ResponseEntity.ok("Student deleted");
    }


}
