package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.Model.Change;
import com.chk.ubbprotool.ubbprotool.dto.ChangeDTO;

public class ChangeMapper {
    public ChangeDTO toDTO(Change source)
    {
        ChangeDTO result = new ChangeDTO();

        result.setChangeStatus(source.getChangeStatus());
        result.setStartDate(source.getStartDate());
        result.setEndDate(source.getEndDate());
        result.setUniversityClass(source.getUniversityClass());
        result.setStudent(source.getStudent());
        result.setMessage(source.getMessage());

        return result;
    }

    public Change toEntity(ChangeDTO source)
    {
        Change result = new Change();

        result.setChangeStatus(source.getChangeStatus());
        result.setStartDate(source.getStartDate());
        result.setEndDate(source.getEndDate());
        result.setUniversityClass(source.getUniversityClass());
        result.setStudent(source.getStudent());
        result.setMessage(source.getMessage());

        return result;
    }
}
