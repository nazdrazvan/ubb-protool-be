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
public class TeacherForEditDTO {
    private Long teacherId;
    private Boolean teacherAvailability;
    private String teacherFirstName;
    private String teacherLastName;
    private String teacherWebSite;
}
