package com.chk.ubbprotool.ubbprotool.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="message_id")
    private int messageId;
     @Column(name="message_date") @NonNull
    private Date messageDate;
     @Column(name="message_time") @NonNull
    private Time messageTime;
     @Column(name="text") @NonNull
    private String messageText;

    @OneToOne
    @JoinColumn(name="change_id", nullable=false)
    private Change change;





}
