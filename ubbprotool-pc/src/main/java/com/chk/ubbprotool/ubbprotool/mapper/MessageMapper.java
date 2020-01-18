package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.Model.Change;
import com.chk.ubbprotool.ubbprotool.Model.Message;
import com.chk.ubbprotool.ubbprotool.Repository.ChangeRepository;
import com.chk.ubbprotool.ubbprotool.dto.MessageDTO;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class MessageMapper {

    @Autowired
    private ChangeRepository changeRepository;

    public MessageDTO toDTO(Message source)
    {
        MessageDTO result = new MessageDTO();

        result.setMessageId(source.getMessageId());
        result.setMessageDate(source.getMessageDate());
        result.setMessageText(source.getMessageText());
        result.setChangeId(source.getChange().getChangeId());

        return result;
    }

    public Message toEntity(MessageDTO source)
    {
        Message result = new Message();

        result.setMessageId(source.getMessageId());
        result.setMessageDate(source.getMessageDate());
        result.setMessageText(source.getMessageText());
        Change c = changeRepository.findById(source.getChangeId());
        result.setChange(c);

        return result;
    }
}
