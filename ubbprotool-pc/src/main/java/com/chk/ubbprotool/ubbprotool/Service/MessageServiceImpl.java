package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Change;
import com.chk.ubbprotool.ubbprotool.Model.Message;
import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import com.chk.ubbprotool.ubbprotool.Repository.MessageRepository;
import com.chk.ubbprotool.ubbprotool.dto.MessageDTO;
import com.chk.ubbprotool.ubbprotool.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan("com.chk.ubbprotool.ubbprotool")
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageMapper messageMapper;

    @Override
    @Transactional
    public void createMessage(MessageDTO message) {
        messageRepository.saveData(messageMapper.toEntity(message));
    }

    @Override
    @Transactional
    public void deleteMessage(Long messageId) {
        messageRepository.removeData(messageId);
    }

    @Override
    @Transactional
    public void upgradeMessage(MessageDTO message) {
        messageRepository.updateData(messageMapper.toEntity(message));
    }

    @Override
    @Transactional
    public List<MessageDTO> findAllMessages() {
        List<MessageDTO> messageDTOList = new ArrayList<MessageDTO>();

        for (Message message : messageRepository.findAll() )
        {
            MessageDTO messageDTO = messageMapper.toDTO(message) ;
            messageDTOList.add(messageDTO);
        }

        return messageDTOList;

    }

    @Override
    @Transactional
    public MessageDTO findById(Long id) {
        Message message = messageRepository.findById(id);
        return messageMapper.toDTO(message);
    }

    @Override
    @Transactional
    public List<MessageDTO> findAllMessagesByTeacherId(Long teacherId) {
        List<MessageDTO> messageDTOList = new ArrayList<MessageDTO>();

        for (Message message : messageRepository.findAll()) {
            Change change = message.getChange();
            UniversityClass universityClass = change.getUniversityClass();
            Teacher teacher = universityClass.getTeacher();
            Long id = teacher.getTeacherId();
            if (id.equals(teacherId)) {
                MessageDTO messageDTO = messageMapper.toDTO(message);
                messageDTOList.add(messageDTO);
            }
        }
            return messageDTOList;
        }
}
