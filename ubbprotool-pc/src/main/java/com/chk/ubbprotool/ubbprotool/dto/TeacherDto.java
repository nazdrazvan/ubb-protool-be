package com.chk.ubbprotool.ubbprotool.dto;

import lombok.Data;

@Data
public class TeacherDto {
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
