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
@Table(name = "Student")
public class Student {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="student_id")
    private Long studentId;

    @Column(name="first_name") @NonNull
    private String firstName;

    @Column(name="last_name") @NonNull
    private String lastName;

    @Column(name="email") @NonNull
    private String email;

    @Column(name="password") @NonNull
    private String password;

    @Column(name="major") @NonNull

    private String major;

    @Column(name="university") @NonNull
    private String university;

    @Column(name="faculty") @NonNull
    private String faculty;

    @ManyToOne
    @JoinColumn(name="subgroup_id", nullable=false)
    private Subgroup subgroup;

    @OneToMany(cascade = CascadeType.REMOVE ,mappedBy = "student")
    List<Change> changes;




}
