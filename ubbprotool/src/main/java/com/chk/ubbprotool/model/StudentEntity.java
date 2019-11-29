package com.chk.ubbprotool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity extends BaseUserEntity{
    public static final String SUBGROUP_ID = "subgroup_id";

    @Column(name=SUBGROUP_ID)
    private Long subgroup_id;
}
