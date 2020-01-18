package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import com.chk.ubbprotool.ubbprotool.Repository.SubgroupRepository;
import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.dto.StudentForRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentForRegisterMapper {

    @Autowired
    private SubgroupRepository subgroupRepository;

    public StudentForRegisterDTO toDTO(Student stud) {
        StudentForRegisterDTO student = new StudentForRegisterDTO();
        student.setStudentId(stud.getStudentId());
        student.setPassword(stud.getPassword());
        student.setEmail(stud.getEmail());
        student.setFaculty(stud.getFaculty());
        student.setFirstName(stud.getFirstName());
        student.setLastName(stud.getLastName());
        student.setMajor(stud.getMajor());
        student.setUniversity(stud.getUniversity());
        student.setStudentGroup(stud.getSubgroup().getGroupNumber());
        student.setStudentSubGroup(stud.getSubgroup().getSubgroupNumber());
        return student;
    }

    public Student toEntity(StudentForRegisterDTO stud) {
        Student student = new Student();
        student.setStudentId(stud.getStudentId());
        student.setPassword(stud.getPassword());
        student.setEmail(stud.getEmail());
        student.setFaculty(stud.getFaculty());
        student.setFirstName(stud.getFirstName());
        student.setLastName(stud.getLastName());
        student.setMajor(stud.getMajor());
        student.setUniversity(stud.getUniversity());
        Subgroup sb = subgroupRepository.findByGroupAndSubgroup(stud.getStudentGroup(), stud.getStudentSubGroup());
        student.setSubgroup(sb);

        return student;
    }

}
