package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Change;
import com.chk.ubbprotool.ubbprotool.Repository.ChangeRepository;
import com.chk.ubbprotool.ubbprotool.dto.ChangeDTO;
import com.chk.ubbprotool.ubbprotool.mapper.ChangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan(basePackages = "com.chk.ubbprotool.ubbprotool")
public class ChangeServiceImpl implements ChangeService {

    @Autowired
    private ChangeRepository changeRepository;

    @Autowired
    private ChangeMapper changeMapper;

    @Override
    @Transactional
    public void createChange(ChangeDTO change) {
        changeRepository.saveData(changeMapper.toEntity(change));
    }

    @Override
    @Transactional
    public void deleteChange(int changeId) {
        changeRepository.removeData(changeId);
    }

    @Override
    @Transactional
    public void upgradeChange(ChangeDTO change) {
        changeRepository.updateData(changeMapper.toEntity(change));
    }

    @Override
    @Transactional
    public List<ChangeDTO> findAllChanges() {
        List<ChangeDTO> changeDTOList = new ArrayList<ChangeDTO>();

        for (Change stud : changeRepository.findAll() )
        {
            ChangeDTO studDTO = changeMapper.toDTO(stud) ;
            changeDTOList.add(studDTO);
        }

        return changeDTOList;
    }

    @Override
    @Transactional
    public List<ChangeDTO> findAllChangesByStudentId(int studentId) {
        List<Change> allChanges = changeRepository.findAll();
        List<ChangeDTO> dtoChangesOfStudent = new ArrayList<>();
        allChanges.forEach(change -> {
            if (studentId == change.getStudent().getStudentId()){
                dtoChangesOfStudent.add(changeMapper.toDTO(change));
            }
        });
        return dtoChangesOfStudent;
    }


    @Override
    @Transactional
    public ChangeDTO findById(int id) {
        Change change = changeRepository.findById(id);
        return changeMapper.toDTO(change);
    }

}
