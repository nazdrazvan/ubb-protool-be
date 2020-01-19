package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import com.chk.ubbprotool.ubbprotool.Service.ChangeService;
import com.chk.ubbprotool.ubbprotool.Service.UniversityClassService;
import com.chk.ubbprotool.ubbprotool.Service.UniversityClassService;
import com.chk.ubbprotool.ubbprotool.dto.ChangeDTO;
import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.dto.UniversityClassDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private ChangeService changeService;

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

    @GetMapping("/getScheduleStudent/{studentId}/{date}")
    public ResponseEntity<List<UniversityClassDTO>> getClassesForStudent(@PathVariable("studentId") String studentId , @PathVariable("date")String date) throws Exception {
        List<ChangeDTO> changes = changeService.findAllChangesByStudentId(Long.parseLong(studentId));
        Date currentDate=Date.valueOf(date);//converting string into sql date
        return ResponseEntity.ok(universityClassService.getClassesForStudent(Long.parseLong(studentId), currentDate, changes));
    }

    @PostMapping("/getScheduleTeacher/{teacherId}/{date}")
    public ResponseEntity<List<UniversityClassDTO>> getClassesForTeacher(@PathVariable("teacherId") Long teacherId , @PathVariable("date")String date)
    {
        Date currentDate=Date.valueOf(date);//converting string into sql date
        return ResponseEntity.ok(universityClassService.getClassesForTeacher(teacherId, currentDate));
    }

    @PostMapping("/getPosiibleClassesForChanged/{classId}/{date}")
    public ResponseEntity<List<UniversityClassDTO>> getPossibleClassesForChange(@PathVariable("classId") Long classId , @PathVariable("date")String date)
    {
        Date currentDate=Date.valueOf(date);//converting string into sql date
        return ResponseEntity.ok(universityClassService.getPossibleClassesToBeChanged(classId, currentDate));
    }

    @GetMapping("/get-by-id/{classId}")
    public ResponseEntity<UniversityClassDTO> getStudentById(@PathVariable("classId") Long classId) throws IOException {
        return new ResponseEntity<>(universityClassService.findById(classId), HttpStatus.OK);
    }

    @GetMapping("/get-all-students-by-class-id/{classId}")
    public ResponseEntity<List<StudentDTO>> getAllStudentsByClassId(@PathVariable("classId") Long classId) throws IOException {
        return new ResponseEntity<>(universityClassService.findAllStudentsByClassId(classId), HttpStatus.OK);
    }
}
