package com.chk.ubbprotool.ubbprotool.Model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int teacherId;


    @Column(name="department") @NonNull
    private String teacherDepartment;


    @Column(name="thesis_availability") @NonNull
    private boolean teacherAvailability;

    @Column(name="first_name") @NonNull
    private String teacherFirstName;

    @Column(name="last_name") @NonNull
    private String teacherLastName;

    @Column(name="email") @NonNull
    private String teacherEmail;

    @Column(name="password") @NonNull
    private String teacherPassword;

    @Column(name="enabled") @NonNull
    private boolean teacherEnabled;

    @Column(name="university") @NonNull
    private String teacherUniversity;

    @Column(name="faculty") @NonNull
    private String teacherFaculty;

    @Column(name="website") @NonNull
    private String teacherWebSite;

    @OneToMany(mappedBy = "teacher")
    Set<UniversityClass> classes;





}
