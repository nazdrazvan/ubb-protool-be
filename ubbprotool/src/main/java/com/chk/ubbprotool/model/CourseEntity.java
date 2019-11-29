package com.chk.ubbprotool.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    public static final String ID_COLUMN = "course_id";
    public static final String COURSE_NAME = "course_name";
    public static final String SEMESTER = "semester";

    @Id
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = COURSE_NAME)
    private String courseName;

    @Column(name = SEMESTER)
    private String semester;


}
