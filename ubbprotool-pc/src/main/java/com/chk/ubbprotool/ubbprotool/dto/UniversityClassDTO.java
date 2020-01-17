package com.chk.ubbprotool.ubbprotool.dto;

import com.chk.ubbprotool.ubbprotool.Model.Course;
import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class UniversityClassDTO {

    private String classType;

    private String classDay;

    private int classWeek;

    private Time classHour;

    private String classLocation;

    private int classDuration;

    private Teacher teacher;

    private Course course;

    private Subgroup subgroup;
}
