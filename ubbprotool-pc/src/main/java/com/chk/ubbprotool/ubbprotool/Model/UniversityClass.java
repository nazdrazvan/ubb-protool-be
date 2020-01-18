package com.chk.ubbprotool.ubbprotool.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "University_Class")
public class UniversityClass {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="class_id")
    private Long classId;

    @Column(name="type") @NonNull
    private String classType;

    @Column(name="day") @NonNull
    private String classDay;

    @Column(name="week") @NonNull
    private int classWeek;

    @Column(name="hour") @NonNull
    private String classHour;

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

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "universityClass")
    Set<Change> changes;

}
