package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import com.chk.ubbprotool.ubbprotool.Repository.SubgroupRepository;
import com.chk.ubbprotool.ubbprotool.dto.SubgroupDTO;
import com.chk.ubbprotool.ubbprotool.mapper.SubgroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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
    @Transactional
    public void createSubgroup(SubgroupDTO subgroup) {
        subgroupRepository.saveData(subgroupMapper.toEntity(subgroup));
    }

    @Override
    @Transactional
    public void deleteSubgroup(Long subgroupId) {
        subgroupRepository.removeData(subgroupId);
    }

    @Override
    @Transactional
    public void upgradeSubgroup(SubgroupDTO subgroup) {
        subgroupRepository.updateData(subgroupMapper.toEntity(subgroup));
    }

    @Override
    @Transactional
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
    @Transactional
    public SubgroupDTO findById(Long id) {
        Subgroup subgroup = subgroupRepository.findById(id);
        if (subgroup == null) {
            return null;
        }
        return subgroupMapper.toDTO(subgroup);
    }

    @Override
    @Transactional
    public SubgroupDTO findByGroupAndSubgroup(Integer group, Integer subGroup) {
        Subgroup subgroup = subgroupRepository.findByGroupAndSubgroup(group, subGroup);
        if (subgroup == null) {
            return null;
        }
        return subgroupMapper.toDTO(subgroup);
    }
}
