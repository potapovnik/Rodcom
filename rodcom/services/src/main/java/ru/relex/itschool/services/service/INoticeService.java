package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcNoticeDto;

import java.util.List;


/**
 * @author : sasha
 */
public interface INoticeService {

    RcNoticeDto getById(int id);
    RcNoticeDto createNotice(RcNoticeDto notice);
    RcNoticeDto updateNotice(RcNoticeDto notice);
    boolean deleteNotice(RcNoticeDto notice);
    List<RcNoticeDto> getNotices();
}
