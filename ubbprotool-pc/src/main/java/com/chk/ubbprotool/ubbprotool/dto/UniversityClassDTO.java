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
public class UniversityClassDTO {
    int classId;
    private String classType;
    private String classDay;
    private int classWeek;
    private String classHour;
    private String classLocation;
    private int classDuration;
    private int teacherId;
    private int courseId;
    private Long subgroupId;
}
