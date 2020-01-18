package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.Model.Change;
import com.chk.ubbprotool.ubbprotool.Model.Message;
import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Repository.MessageRepository;
import com.chk.ubbprotool.ubbprotool.Repository.StudentRepository;
import com.chk.ubbprotool.ubbprotool.dto.ChangeDTO;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ChangeMapper {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MessageRepository messageRepository;

    public ChangeDTO toDTO(Change source)
    {
        ChangeDTO result = new ChangeDTO();

        result.setChangeId(source.getChangeId());
        result.setChangeStatus(source.getChangeStatus());
        result.setStartDate(source.getStartDate());
        result.setEndDate(source.getEndDate());
        result.setUniversityClass(source.getUniversityClass());
        result.setStudentId(source.getStudent().getStudentId());
//        result.setMessageId(source.getMessage().getMessageId());

        return result;
    }

    public Change toEntity(ChangeDTO source)
    {
        Change result = new Change();

        result.setChangeId(source.getChangeId());
        result.setChangeStatus(source.getChangeStatus());
        result.setStartDate(source.getStartDate());
        result.setEndDate(source.getEndDate());
        result.setUniversityClass(source.getUniversityClass());
        Student s = studentRepository.findById(source.getStudentId());
        result.setStudent(s);
//        Message m = messageRepository.findById(source.getMessageId());
//        result.setMessage(m);

        return result;
    }
}
