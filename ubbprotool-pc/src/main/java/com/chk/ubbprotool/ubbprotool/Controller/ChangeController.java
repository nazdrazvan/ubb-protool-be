package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.Service.ChangeService;
import com.chk.ubbprotool.ubbprotool.dto.ChangeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/change")
public class ChangeController {
    @Autowired
    private ChangeService changeService;

    @GetMapping("/list")
    public ResponseEntity<List<ChangeDTO>> listChanges() {
        return  ResponseEntity.ok(changeService.findAllChanges());
    }


    @PostMapping("/saveChange")
    public ResponseEntity<String> saveChange(@RequestBody ChangeDTO theChange) throws IOException {
        changeService.createChange(theChange);
        return ResponseEntity.ok("Change saved");
    }

    @PostMapping("/deleteChange")
    public ResponseEntity<String> deleteChange(@RequestParam("ChangeId") int theId) {
        changeService.deleteChange(theId);
        return ResponseEntity.ok("Change deleted");
    }

    @PostMapping("/updateChange")
    public ResponseEntity<String> updateChange(@RequestBody ChangeDTO theChange) throws IOException {
        changeService.upgradeChange(theChange);
        return ResponseEntity.ok("Change updated");
    }

//    @GetMapping("/get-changes-by-student-id/{studentId}")
//    public ResponseEntity<List<ChangeDTO>> getAllChangesOfAStudentById(@PathVariable("studentId") int studentId) {
//        return new ResponseEntity<>(changeService.findAllChangesByStudentId(studentId), HttpStatus.OK);
//    }

}
