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
    private int subgroupId;

    @Column(name="group_number") @NonNull
    private int groupNumber;

    @Column(name="subgroup_number") @NonNull
    private int subgroupNumber;

    @OneToMany(mappedBy = "subgroup")
    List<Student> students;

    @OneToMany(mappedBy = "subgroup")
    List<UniversityClass> classes;


}
