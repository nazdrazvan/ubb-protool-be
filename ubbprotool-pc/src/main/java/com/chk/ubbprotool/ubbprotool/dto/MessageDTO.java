package com.chk.ubbprotool.ubbprotool.dto;

import com.chk.ubbprotool.ubbprotool.Model.Change;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class MessageDTO {
    private Long messageId;
    private Date messageDate;
    private String messageText;
    private Long changeId;
}
