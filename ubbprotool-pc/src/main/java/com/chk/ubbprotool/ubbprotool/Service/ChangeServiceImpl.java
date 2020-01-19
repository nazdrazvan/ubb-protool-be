package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Change;
import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Repository.ChangeRepository;
import com.chk.ubbprotool.ubbprotool.Repository.StudentRepository;
import com.chk.ubbprotool.ubbprotool.dto.ChangeDTO;
import com.chk.ubbprotool.ubbprotool.mapper.ChangeMapper;
import org.apache.tomcat.jni.Error;
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
    private StudentRepository studentRepository;

    @Autowired
    private ChangeMapper changeMapper;

    @Override
    @Transactional
    public Long createChange(ChangeDTO change) {
        return changeRepository.saveData(changeMapper.toEntity(change));
    }

    @Override
    @Transactional
    public void deleteChange(Long changeId) {
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

//    @Override
//    @Transactional
//    public List<ChangeDTO> findAllChangesByStudentId(int studentId) {
//        if (studentRepository.findById(studentId) == null){
//            throw new RuntimeException("Student does not exist!");
//        }
//        List<Change> allChanges = changeRepository.findAll();
//        List<ChangeDTO> dtoChangesOfStudent = new ArrayList<>();
//        allChanges.forEach(change -> {
//            if (studentId == change.getStudent().getStudentId()){
//                dtoChangesOfStudent.add(changeMapper.toDTO(change));
//            }
//        });
//        return dtoChangesOfStudent;
//    }


    @Override
    @Transactional
    public ChangeDTO findById(Long id) {
        Change change = changeRepository.findById(id);
        return changeMapper.toDTO(change);
    }
    @Override
    @Transactional
    public List<ChangeDTO> findAllChangesByStudentId(Long studentId) throws Exception {

        List<ChangeDTO> changeDTOList = new ArrayList<>();

        Student student = studentRepository.findById(studentId);

        if (student == null)
            throw new Exception("Student doesn't exist");

        if (student.getChanges() == null )
            throw new Exception("No changes for this student");

        for (Change change : student.getChanges()) {
            changeDTOList.add(changeMapper.toDTO(change));
        }


        return changeDTOList;
    }

}
