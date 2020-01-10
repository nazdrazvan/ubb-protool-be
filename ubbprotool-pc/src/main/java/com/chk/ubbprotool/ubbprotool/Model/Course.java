package com.chk.ubbprotool.ubbprotool.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="course_id")
    private int courseId;

    @Column(name="course_name") @NonNull
    private String courseName;
    @Column(name="semester") @NonNull
    private int courseSemester;
    @Column(name="university") @NonNull
    private String courseUniversity;
    @Column(name="faculty") @NonNull
    private String courseFaculty;
    @Column(name="start_date") @NonNull
    private Date courseStartDate;
    @Column(name="end_date") @NonNull
    private Date courseEndDate;

    @OneToMany(mappedBy = "course")
    Set<UniversityClass> classes;


}
