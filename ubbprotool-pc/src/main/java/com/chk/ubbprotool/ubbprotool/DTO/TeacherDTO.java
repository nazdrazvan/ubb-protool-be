package com.chk.ubbprotool.ubbprotool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class TeacherDTO {


    private String teacherDepartment;

    private boolean teacherAvailability;

    private String teacherFirstName;

    private String teacherLastName;

    private String teacherEmail;

    private String teacherPassword;

    private boolean teacherEnabled;

    private String teacherUniversity;

    private String teacherFaculty;

    private String teacherWebSite;

}
