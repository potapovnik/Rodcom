package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import ru.relex.itschool.db.entity.RcMessage;
import ru.relex.itschool.db.repository.IRcMessageRepository;
import ru.relex.itschool.services.modelDto.RcMessageDto;
import ru.relex.itschool.services.service.IRcMessageService;
import ru.relex.itschool.services.mapper.IRcMessageMapper;

import java.util.*;

@Service
public class RcMessageServiceImpl implements IRcMessageService {

    private final IRcMessageRepository repository;
    private final IRcMessageMapper messageMapper;

    public RcMessageServiceImpl(IRcMessageRepository repository, IRcMessageMapper messageMapper) {
        this.repository = repository;
        this.messageMapper = messageMapper;
    }

    public RcMessage getMessageById(int id) {
        Optional<RcMessage> messageOptional = repository.findById(id);
        if (!messageOptional.isPresent())
            return null;
        return messageOptional.get();
    }

    @Override
    public RcMessageDto getById(int id) {
        RcMessage m = getMessageById(id);
        if (m == null)
            return null;
        return messageMapper.toDto(m);
    }

    @Override
    public RcMessageDto createMessage(RcMessageDto messageDto) {
        RcMessage message = messageMapper.fromDto(messageDto);
        message = repository.save(message);
        messageDto.setMessageId(message.getMessageId());
        return messageDto;
    }

    @Override
    public boolean updateMessage(RcMessageDto messageDto) {
        RcMessage message = getMessageById(messageDto.getMessageId());
        if (message == null)
            return false;
        message.setMessageType(messageDto.getMessageType());
        message.setMessage(messageDto.getMessage());
        message.setMessageTime(messageDto.getMessageTime());
        message.setMessageStatus(messageDto.getMessageStatus());
/*        message.setToGroup(messageDto.getToGroup());
        message.setToMember(messageDto.getToMember());
        message.setFromMember(messageDto.getFromMember());*/
        message = repository.save(message);
        return true;
    }

    @Override
    public boolean deleteMessage(RcMessageDto messageDto) {
        RcMessage message = getMessageById(messageDto.getMessageId());
        if (message == null)
            return false;
        repository.delete(message);
        return true;
    }
}
