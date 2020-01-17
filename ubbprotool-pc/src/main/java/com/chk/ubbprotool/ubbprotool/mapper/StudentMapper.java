package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import org.springframework.stereotype.Component;

@Component
public  class StudentMapper {

    public StudentDTO toDTO(Student stud)
    {
        StudentDTO student = new StudentDTO() ;
        student.setPassword(stud.getPassword());
        student.setEmail(stud.getEmail());
        student.setFaculty(stud.getFaculty());
        student.setFirstName(stud.getFirstName());
        student.setLastName(stud.getLastName());
        student.setMajor(stud.getMajor());
        student.setUniversity(stud.getUniversity());
        student.setSubgroupId(stud.getSubgroup().getSubgroupId());

    return student;
    }

    public  Student toEntity(StudentDTO stud)
    {
        Student student = new Student() ;
        student.setPassword(stud.getPassword());
        student.setEmail(stud.getEmail());
        student.setFaculty(stud.getFaculty());
        student.setFirstName(stud.getFirstName());
        student.setLastName(stud.getLastName());
        student.setMajor(stud.getMajor());
        student.setUniversity(stud.getUniversity());
        Subgroup sb = new Subgroup();
        sb.setSubgroupId(stud.getSubgroupId());
        student.setSubgroup(sb);

        return student;
    }

}
