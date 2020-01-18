package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.Service.SubgroupService;
import com.chk.ubbprotool.ubbprotool.dto.SubgroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/subgroup")
public class SubgroupController {
    @Autowired
    private SubgroupService subgroupService;

    @GetMapping("/list")
    public ResponseEntity<List<SubgroupDTO>> listSubgroups() {
        return  ResponseEntity.ok(subgroupService.findAllSubgroups());
    }


    @PostMapping("/saveSubgroup")
    public ResponseEntity<String> saveSubgroup(@RequestBody SubgroupDTO theSubgroup) throws IOException {
        subgroupService.createSubgroup(theSubgroup);
        return ResponseEntity.ok("Subgroup saved");
    }

    @PostMapping("/deleteSubgroup/{subgroupId}")
    public ResponseEntity<String> deleteSubgroup(@PathVariable("subgroupId") Long subgroupId) {
        subgroupService.deleteSubgroup(subgroupId);
        return ResponseEntity.ok("Subgroup deleted");
    }

    @PostMapping("/updateSubgroup")
    public ResponseEntity<String> updateSubgroup(@RequestBody SubgroupDTO theSubgroup) throws IOException {
        subgroupService.upgradeSubgroup(theSubgroup);
        return ResponseEntity.ok("Subgroup updated");
    }

    @GetMapping("/get-by-id/{subgroupId}")
    public ResponseEntity<SubgroupDTO> getStudentById(@PathVariable("subgroupId") Long subgroupId) throws IOException {
        return new ResponseEntity<>(subgroupService.findById(subgroupId), HttpStatus.OK);
    }

}
