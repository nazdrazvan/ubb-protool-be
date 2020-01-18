package com.chk.ubbprotool.ubbprotool.Model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="course_id")
    private Long courseId;

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

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "course")
    Set<UniversityClass> classes;


}
