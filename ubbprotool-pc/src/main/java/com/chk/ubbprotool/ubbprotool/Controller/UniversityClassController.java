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

    @PostMapping("/deleteUniversityClass/{userId}")
    public ResponseEntity<String> deleteUniversityClass(@PathVariable("userId") int userId) {
        universityClassService.deleteUniversityClass(userId);
        return ResponseEntity.ok("UniversityClass deleted");
    }

    @PostMapping("/updateUniversityClass")
    public ResponseEntity<String> updateUniversityClass(@RequestBody UniversityClassDTO theUser) throws IOException {
        universityClassService.updateUniversityClass(theUser);
        return ResponseEntity.ok("UniversityClass updated");
    }

    @PostMapping("/getScheduleStudent/{studentId}/{date}")
    public ResponseEntity<List<UniversityClassDTO>> getClassesForStudent(@PathVariable("studentId") Long studentId , @PathVariable("date")String date)
    {
        Date currentDate=Date.valueOf(date);//converting string into sql date
       return ResponseEntity.ok(universityClassService.getClassesForStudent(studentId, currentDate));
    }

    @PostMapping("/getScheduleTeacher/{teacherId}/{date}")
    public ResponseEntity<List<UniversityClassDTO>> getClassesForTeacher(@PathVariable("teacherId") Long teacherId , @PathVariable("date")String date)
    {
        Date currentDate=Date.valueOf(date);//converting string into sql date
        return ResponseEntity.ok(universityClassService.getClassesForTeacher(teacherId, currentDate));
    }

    @PostMapping("/getPosiibleClassesForChanged")
    public ResponseEntity<List<UniversityClassDTO>> getPossibleClassesForChange(@RequestParam("classId") Long classId , @RequestParam("date")String curentDate)
    {
        Date currentDate=Date.valueOf(curentDate);//converting string into sql date
        return ResponseEntity.ok(universityClassService.getPossibleClassesToBeChanged(classId, currentDate));
    }

}
