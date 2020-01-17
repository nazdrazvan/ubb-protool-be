package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.Service.StudentService;
import com.chk.ubbprotool.ubbprotool.Service.TeacherService;
import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/email-and-password")
    public ResponseEntity<?> verifyEmailAndPassword(@RequestBody StudentDTO studentDTONotStud) throws IOException {
        StudentDTO studentDTO = studentService.findStudentByEmailAndPassword(studentDTONotStud.getEmail(), studentDTONotStud.getPassword());
        TeacherDTO teacherDTO = teacherService.findTeacherByEmailAndPassword(studentDTONotStud.getEmail(), studentDTONotStud.getPassword());

        if (studentDTO == null && teacherDTO == null){
            return new ResponseEntity<>("User can not be found!", HttpStatus.NOT_FOUND);
        }

        if (studentDTO != null && teacherDTO == null){
            return new ResponseEntity<>(studentDTO, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(teacherDTO, HttpStatus.NOT_FOUND);
    }

}
