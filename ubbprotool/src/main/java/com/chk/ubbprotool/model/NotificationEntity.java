package com.chk.ubbprotool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Notification")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEntity {

    public static final String ID_COLUMN = "notification_id";
    public static final String ID_STUDENT = "student_id";
    public static final String ID_CLASS = "class_id";

    @Id
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = ID_STUDENT)
    private Long studentId;

    @Column(name = ID_CLASS)
    private Long classId;

}
