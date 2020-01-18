package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.dto.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    void createMessage(MessageDTO message );

    void deleteMessage(Long messageId);

    void upgradeMessage(MessageDTO message);

    List<MessageDTO> findAllMessages();

    MessageDTO findById(Long id);
    List<MessageDTO> findAllMessagesByTeacherId(Long teacherId);

}
