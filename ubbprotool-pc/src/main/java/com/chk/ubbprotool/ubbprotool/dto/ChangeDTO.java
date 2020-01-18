package com.chk.ubbprotool.ubbprotool.dto;

import com.chk.ubbprotool.ubbprotool.Model.*;
import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class ChangeDTO {
    private Long changeId;
    private String changeStatus;
    private Date startDate;
    private Date endDate;
    private Long universityClassId;
    private Long studentId;
    //private int messageId;
}
