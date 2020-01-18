package com.chk.ubbprotool.ubbprotool.Model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "Schedule_Change")
public class Change {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="change_id")
    private Long changeId;

    @Column(name="change_status") @NonNull
    private String changeStatus;

    @Column(name="start_change_date") @NonNull
    private Date startDate;

    @Column(name="end_change_date") @NonNull
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="class_id", nullable=false)
    private UniversityClass universityClass;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;
//pentru db sa se schimbe trebuie stearsa si creata din nou manual
//    @OneToOne
//    @JoinColumn(name="message_id",nullable = false)
//    private Message message;







}
