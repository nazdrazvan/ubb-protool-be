package com.chk.ubbprotool.ubbprotool.dto;

import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class SubgroupDTO {
    private Long subgroupId;
    private int groupNumber;
    private int subgroupNumber;
}
