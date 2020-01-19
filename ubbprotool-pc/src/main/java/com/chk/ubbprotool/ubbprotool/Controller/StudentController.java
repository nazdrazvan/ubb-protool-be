package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.Service.StudentService;
import com.chk.ubbprotool.ubbprotool.dto.StudentForRegisterDTO;
import com.chk.ubbprotool.ubbprotool.dto.StudentForEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveUser(@RequestBody StudentForRegisterDTO theStudent) throws Exception {
        if (studentService.checkIfStudentDoesNotExists(theStudent.getEmail())) {
            studentService.createStudent(theStudent);
            return ResponseEntity.ok("Student saved");
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PostMapping("/deleteStudent/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
        studentService.deleteStudent(userId);
        return ResponseEntity.ok("Student deleted");
    }

    @PostMapping("/updateStudent")
    public ResponseEntity<String> updateUser(@RequestBody StudentForEditDTO theUser) throws Exception {
        studentService.updateStudent(theUser);
        return ResponseEntity.ok("Student updated");
    }

    @GetMapping("/get-by-id/{student_id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("student_id") Long student_id) throws IOException {
        return new ResponseEntity<>(studentService.findById(student_id), HttpStatus.OK);
    }
}
