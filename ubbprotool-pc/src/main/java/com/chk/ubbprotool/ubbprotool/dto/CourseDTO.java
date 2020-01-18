package com.chk.ubbprotool.ubbprotool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class CourseDTO {
    private Long courseId;
    private String courseName;
    private int courseSemester;
    private String courseUniversity;
    private String courseFaculty;
    private Date courseStartDate;
    private Date courseEndDate;
}
