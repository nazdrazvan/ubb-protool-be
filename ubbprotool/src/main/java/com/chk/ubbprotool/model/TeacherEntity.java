package com.chk.ubbprotool.model;

import com.sun.xml.bind.v2.model.core.ID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity extends BaseUserEntity {
    public static final String ID_COLUMN = "thesis_capacity";
    public static final String DEPARTAMENT = "departament";

    @Id
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = DEPARTAMENT)
    private String departament;

}
