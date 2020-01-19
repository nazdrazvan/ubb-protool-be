package com.chk.ubbprotool.ubbprotool.Model;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long teacherId;

    @Column(name="department") @NonNull
    private String teacherDepartment;

    @Column(name="thesis_availability") @NonNull
    private boolean teacherAvailability;

    @Column(name="first_name") @NonNull
    private String teacherFirstName;

    @Column(name="last_name") @NonNull
    private String teacherLastName;

    @Column(name="email") @NonNull
    private String email;

    @Column(name="password") @NonNull
    private String password;

    @Column(name="enabled") @NonNull
    private boolean teacherEnabled;

    @Column(name="university") @NonNull
    private String teacherUniversity;

    @Column(name="faculty") @NonNull
    private String teacherFaculty;

    @Column(name="website") @NonNull
    private String teacherWebSite;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "teacher")
    List<UniversityClass> classes;





}
