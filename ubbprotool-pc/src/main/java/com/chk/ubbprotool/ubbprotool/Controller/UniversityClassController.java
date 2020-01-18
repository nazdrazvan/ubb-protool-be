package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import com.chk.ubbprotool.ubbprotool.Service.UniversityClassService;
import com.chk.ubbprotool.ubbprotool.Service.UniversityClassService;
import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.dto.UniversityClassDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/class")
public class UniversityClassController {
    @Autowired
    private UniversityClassService universityClassService;

    @GetMapping("/list")
    public ResponseEntity<List<UniversityClassDTO>> listClasses() {
        return  ResponseEntity.ok(universityClassService.findAllUniversityClasses());
    }


    @PostMapping("/saveUniversityClass")
    public ResponseEntity<String> saveUniversityClass(@RequestBody UniversityClassDTO theUniversityClass) throws IOException {
        universityClassService.createUniversityClass(theUniversityClass);
        return ResponseEntity.ok("UniversityClass saved");
    }

    @PostMapping("/deleteUniversityClass")
    public ResponseEntity<String> deleteUniversityClass(@RequestParam("UserId") int theId) {
        universityClassService.deleteUniversityClass(theId);
        return ResponseEntity.ok("UniversityClass deleted");
    }

    @PostMapping("/updateUniversityClass")
    public ResponseEntity<String> updateUniversityClass(@RequestBody UniversityClassDTO theUser) throws IOException {
        universityClassService.updateUniversityClass(theUser);
        return ResponseEntity.ok("UniversityClass updated");
    }

    @PostMapping("/getScheduleStudent")
    public ResponseEntity<List<UniversityClassDTO>> getClassesForStudent(@RequestParam("StudentId") Long studentId , @RequestParam("Date")String curentDate)
    {
        Date currentDate=Date.valueOf(curentDate);//converting string into sql date
       return ResponseEntity.ok(universityClassService.getClassesForStudent(studentId, currentDate));
    }

    @GetMapping("/getAllStudentsByClassId")
    public ResponseEntity<List<StudentDTO>> studentClasses(@RequestParam("ClassId") Long classId ) {
        return ResponseEntity.ok(universityClassService.findAllStudentsByClassId(classId));
    }
    @PostMapping("/getScheduleTeacher")
    public ResponseEntity<List<UniversityClassDTO>> getClassesForTeacher(@RequestParam("TeacherId") int teacherId , @RequestParam("Date")String curentDate)
    {
        Date currentDate=Date.valueOf(curentDate);//converting string into sql date
        return ResponseEntity.ok(universityClassService.getClassesForTeacher(teacherId, currentDate));
    }
}
