package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import com.chk.ubbprotool.ubbprotool.Repository.SubgroupRepository;
import com.chk.ubbprotool.ubbprotool.dto.SubgroupDTO;
import com.chk.ubbprotool.ubbprotool.mapper.SubgroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan(basePackages = "com.chk.ubbprotool.ubbprotool")
public class SubgroupServiceImpl implements SubgroupService {

    @Autowired
    private SubgroupRepository subgroupRepository;

    @Autowired
    private SubgroupMapper subgroupMapper;


    @Override
    public void createSubgroup(SubgroupDTO subgroup) {
        subgroupRepository.saveData(subgroupMapper.toEntity(subgroup));
    }

    @Override
    public void deleteSubgroup(int subgroupId) {
        subgroupRepository.removeData(subgroupId);
    }

    @Override
    public void upgradeSubgroup(SubgroupDTO subgroup) {
        subgroupRepository.saveData(subgroupMapper.toEntity(subgroup));
    }

    @Override
    public List<SubgroupDTO> findAllSubgroups() {
        List<SubgroupDTO> subgroupDTOList = new ArrayList<SubgroupDTO>();

        for (Subgroup subgroup : subgroupRepository.findAll() )
        {
            SubgroupDTO studDTO = subgroupMapper.toDTO(subgroup) ;
            subgroupDTOList.add(studDTO);
        }

        return subgroupDTOList;
    }

    @Override
    public SubgroupDTO findById(int id) {
        Subgroup subgroup = subgroupRepository.findById(id);
        return subgroupMapper.toDTO(subgroup);
    }
}
