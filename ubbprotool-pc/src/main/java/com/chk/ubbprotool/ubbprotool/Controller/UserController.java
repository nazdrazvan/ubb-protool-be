package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.Service.StudentService;
import com.chk.ubbprotool.ubbprotool.Service.TeacherService;
import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.dto.StudentForRegisterDTO;
import com.chk.ubbprotool.ubbprotool.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/login/email-and-password")
    public ResponseEntity<?> verifyEmailAndPassword(@RequestBody StudentDTO studentDTONotStud) throws IOException {
        StudentForRegisterDTO studentDTO = studentService.findStudentByEmailAndPassword(studentDTONotStud.getEmail(), studentDTONotStud.getPassword());
        TeacherDTO teacherDTO = teacherService.findTeacherByEmailAndPassword(studentDTONotStud.getEmail(), studentDTONotStud.getPassword());

        if (studentDTO == null && teacherDTO == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        if (studentDTO != null && teacherDTO == null){
            return new ResponseEntity<>(studentDTO, HttpStatus.FOUND);
        }

        return new ResponseEntity<>(teacherDTO, HttpStatus.FOUND);
    }
}
