package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.dto.ChangeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChangeService {

    Long createChange(ChangeDTO change );

    void deleteChange(Long changeId);

    void upgradeChange(ChangeDTO change);

    List<ChangeDTO> findAllChanges();
    
//    List<ChangeDTO> findAllChangesByStudentId(int studentId);

    ChangeDTO findById(Long id);
    List<ChangeDTO> findAllChangesByStudentId(Long studentId) throws Exception;

}
