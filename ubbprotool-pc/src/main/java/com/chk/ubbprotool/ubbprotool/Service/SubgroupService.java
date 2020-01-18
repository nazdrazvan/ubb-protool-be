package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.dto.SubgroupDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SubgroupService {
    void createSubgroup(SubgroupDTO subgroup );

    void deleteSubgroup(Long subgroupId);

    void upgradeSubgroup(SubgroupDTO subgroup);

    List<SubgroupDTO> findAllSubgroups();

    SubgroupDTO findById(Long id);

    SubgroupDTO findByGroupAndSubgroup(Integer group, Integer subgroup);
}
