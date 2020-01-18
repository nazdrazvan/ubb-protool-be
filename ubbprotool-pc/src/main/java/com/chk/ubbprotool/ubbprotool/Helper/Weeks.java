package com.chk.ubbprotool.ubbprotool.Helper;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "Weeks")
public class Weeks {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="week_id")
    private Long weekId;

    @Column(name="week_number") @NonNull
    private int weekNumber;

    @Column(name="start_date") @NonNull
    private Date startDate;

    @Column(name="end_date") @NonNull
    private Date endDate;

}
