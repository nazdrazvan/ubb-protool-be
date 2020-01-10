package com.chk.ubbprotool.ubbprotool.DTO;

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
public class StudentDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String major;
    private String university;
    private String faculty;
    private int subgroupId;
}
