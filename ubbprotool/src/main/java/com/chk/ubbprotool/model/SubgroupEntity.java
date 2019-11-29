package com.chk.ubbprotool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subgroup")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubgroupEntity {

    public static final String ID_COLUMN = "subgroup_id";
    public static final String GROUP_NUMBER = "group_number";
    public static final String SUBGROUP_NUMBER = "subgroup_number";

    @Id
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = GROUP_NUMBER)
    private String groupNumber;

    @Column(name = SUBGROUP_NUMBER)
    private String subgroupNumber;

}
