package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcNoticeTypeDto;

/**
 * @author : sasha
 */
public interface INoticeTypeService {

    RcNoticeTypeDto getById(int id);
    RcNoticeTypeDto createUpdateNoticeType(RcNoticeTypeDto noticeType);
    boolean deleteNoticeType(RcNoticeTypeDto noticeType);
}
