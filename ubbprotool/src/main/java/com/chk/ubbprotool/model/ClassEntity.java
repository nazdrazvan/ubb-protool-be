package com.chk.ubbprotool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Class")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassEntity {
    public static final String ID_COLUMN = "class_id";
    public static final String TEACHER_ID = "teacher_id";
    public static final String COURSE_ID = "course_id";
    public static final String SUBGROUP_ID = "subgroup_id";
    public static final String COURSE_TYPE = "course_type";
    public static final String DAY = "day";
    public static final String WEEK = "week";
    public static final String HOUR = "hour";
    public static final String LOCATION = "location";
    public static final String CAPACITY = "capacity";

    @Id
    @Column(name=ID_COLUMN)
    private Long id;

    @Column(name=TEACHER_ID)
    private Long teacher_id;

    @Column(name=COURSE_ID)
    private Long course_id;

    @Column(name=SUBGROUP_ID)
    private Long subgroup_id;

    @Column(name=COURSE_TYPE)
    private String course_type;

    @Column(name=DAY)
    private String day;

    @Column(name=WEEK)
    private int week;

    @Column(name=HOUR)
    private Date hour;

    @Column(name=LOCATION)
    private String location;

    @Column(name=CAPACITY)
    private int capacity;


}
