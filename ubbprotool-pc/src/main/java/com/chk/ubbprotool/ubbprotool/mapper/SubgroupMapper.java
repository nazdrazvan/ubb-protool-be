package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.dto.SubgroupDTO;
import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import org.springframework.stereotype.Component;

@Component
public class SubgroupMapper {

    public Subgroup toEntity(SubgroupDTO source)
    {
        Subgroup result = new Subgroup();

        result.setSubgroupId(source.getSubgroupId());
        result.setGroupNumber(source.getGroupNumber());
        result.setSubgroupNumber(source.getSubgroupNumber());

        return result;
    }

    public SubgroupDTO toDTO(Subgroup source)
    {
        SubgroupDTO result = new SubgroupDTO();

        result.setSubgroupId(source.getSubgroupId());
        result.setGroupNumber(source.getGroupNumber());
        result.setSubgroupNumber(source.getSubgroupNumber());


        return result;
    }

}
