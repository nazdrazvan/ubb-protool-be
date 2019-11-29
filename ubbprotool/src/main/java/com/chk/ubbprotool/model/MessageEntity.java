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
@Table(name="Message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {
    public static final String ID_COLUMN = "message_id";
    public static final String CHANGE_ID = "change_id";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String TEXT = "text";

    @Id
    @Column(name=ID_COLUMN)
    private Long id;

    @Column(name=CHANGE_ID)
    private Long change_id;

    @Column(name=DATE)
    private Date date;

    @Column(name=TIME)
    private Date time;

    @Column(name=TEXT)
    private String text;
}
