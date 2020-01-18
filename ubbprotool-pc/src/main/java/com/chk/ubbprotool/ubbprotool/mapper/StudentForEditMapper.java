package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import com.chk.ubbprotool.ubbprotool.Repository.StudentRepository;
import com.chk.ubbprotool.ubbprotool.Repository.SubgroupRepository;
import com.chk.ubbprotool.ubbprotool.dto.StudentForEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentForEditMapper {

    @Autowired
    private SubgroupRepository subgroupRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Student toEntity(StudentForEditDTO stud) {
        Student student = studentRepository.findById(stud.getStudentId());
        student.setFirstName(stud.getFirstName());
        student.setLastName(stud.getLastName());
        Subgroup sb = subgroupRepository.findByGroupAndSubgroup(stud.getStudentGroup(), stud.getStudentSubGroup());
        student.setSubgroup(sb);
        return student;
    }
}
