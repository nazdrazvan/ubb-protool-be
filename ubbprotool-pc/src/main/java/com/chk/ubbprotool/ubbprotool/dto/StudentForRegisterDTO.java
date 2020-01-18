package com.chk.ubbprotool.ubbprotool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class StudentForRegisterDTO {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String major;
    private String university;
    private String faculty;
    private Integer studentGroup;
    private Integer studentSubGroup;
}
