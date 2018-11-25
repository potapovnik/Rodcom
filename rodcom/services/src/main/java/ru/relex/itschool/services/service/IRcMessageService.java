package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcMessageDto;
import java.util.*;

public interface IRcMessageService {
    public RcMessageDto getById(int id);
    public RcMessageDto createMessage(RcMessageDto message);
    public boolean updateMessage(RcMessageDto message);
    public boolean deleteMessage(int id);
    public List<RcMessageDto> getMessagesToGroup(int groupId);
    public List<RcMessageDto> getMessagesToMember(int memberId);
    public List<RcMessageDto> getMessagesFromMember(int memberId);
}
