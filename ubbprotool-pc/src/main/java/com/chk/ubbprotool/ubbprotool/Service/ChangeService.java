package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.dto.ChangeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChangeService {

    void createChange(ChangeDTO change );

    void deleteChange(int changeId);

    void upgradeChange(ChangeDTO change);

    List<ChangeDTO> findAllChanges();

    ChangeDTO findById(int id);



}
