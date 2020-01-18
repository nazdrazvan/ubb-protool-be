package com.chk.ubbprotool.ubbprotool.Model;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Data
@Table(name = "Subgroup")
public class Subgroup {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="subgroup_id")
    private Long subgroupId;

    @Column(name="group_number") @NonNull
    private Integer groupNumber;

    @Column(name="subgroup_number") @NonNull
    private Integer subgroupNumber;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "subgroup")
    List<Student> students;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "subgroup")
    List<UniversityClass> classes;


}
