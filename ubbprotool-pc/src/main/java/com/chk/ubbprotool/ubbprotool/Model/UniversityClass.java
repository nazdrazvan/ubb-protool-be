package com.chk.ubbprotool.ubbprotool.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "University_Class")
public class UniversityClass {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="class_id")
    private int classId;

    @Column(name="type") @NonNull
    private String classType;

    @Column(name="day") @NonNull
    private String classDay;

    @Column(name="week") @NonNull
    private int classWeek;

    @Column(name="hour") @NonNull
    private Time classHour;

    @Column(name="location") @NonNull
    private String classLocation;

    @Column(name="duration") @NonNull
    private int classDuration;

    @ManyToOne
    @JoinColumn(name="teacher_id", nullable=false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    @ManyToOne
    @JoinColumn(name="subgroup_id", nullable=false)
    private Subgroup subgroup;

}
