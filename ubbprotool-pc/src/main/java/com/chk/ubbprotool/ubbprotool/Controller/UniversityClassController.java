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

    @PostMapping("/getSchedule")
    public ResponseEntity<List<UniversityClassDTO>> getClassesForStudent(@RequestParam("StudentId") int studentId , @RequestParam("Date")String curentDate)
    {
        Date currentDate=Date.valueOf(curentDate);//converting string into sql date
       return ResponseEntity.ok(universityClassService.getClassesForStudent(studentId, currentDate));
    }

}
