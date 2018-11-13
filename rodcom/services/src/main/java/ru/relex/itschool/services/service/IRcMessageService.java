package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcMessageDto;
import java.util.*;

public interface IRcMessageService {
    public RcMessageDto getById(int id);
    public RcMessageDto createMessage(RcMessageDto message);
    public boolean updateMessage(RcMessageDto message);
    public boolean deleteMessage(RcMessageDto message);
/*    public List<RcMessageDto> getAllMessagesToGroup(int groupId);
    public List<RcMessageDto> getAllMessagesToMember(int memberId);
    public List<RcMessageDto> getAllMessagesFromMember(int memberId);*/
}
