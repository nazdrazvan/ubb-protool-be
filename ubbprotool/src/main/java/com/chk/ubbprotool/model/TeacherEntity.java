package com.chk.ubbprotool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity extends BaseUserEntity {
    public static final String THESIS_CAPACITY = "thesis_capacity";
    public static final String DEPARTAMENT = "departament";

    @Column(name = THESIS_CAPACITY)
    private Integer thesisCapacity;

    @Column(name = DEPARTAMENT)
    private String departament;

}
