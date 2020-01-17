package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.Model.Course;
import com.chk.ubbprotool.ubbprotool.Model.Message;
import com.chk.ubbprotool.ubbprotool.dto.CourseDTO;
import com.chk.ubbprotool.ubbprotool.dto.MessageDTO;

public class MessageMapper {
    public MessageDTO toDTO(Message source)
    {
        MessageDTO result = new MessageDTO();

        result.setMessageDate(source.getMessageDate());
        result.setMessageTime(source.getMessageTime());
        result.setMessageText(source.getMessageText());
        result.setChange(source.getChange());

        return result;
    }

    public Message toEntity(MessageDTO source)
    {
        Message result = new Message();

        result.setMessageDate(source.getMessageDate());
        result.setMessageTime(source.getMessageTime());
        result.setMessageText(source.getMessageText());
        result.setChange(source.getChange());

        return result;
    }
}
