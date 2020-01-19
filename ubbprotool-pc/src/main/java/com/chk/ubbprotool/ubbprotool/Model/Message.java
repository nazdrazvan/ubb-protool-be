package com.chk.ubbprotool.ubbprotool.Model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="message_id")
    private Long messageId;
     @Column(name="message_date") @NonNull
    private Date messageDate;

     @Column(name="text") @NonNull
    private String messageText;

    @OneToOne
    @JoinColumn(name="change_id", nullable=false)
    private Change change;





}
