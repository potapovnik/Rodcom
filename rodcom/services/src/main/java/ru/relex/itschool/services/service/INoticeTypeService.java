package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcNoticeTypeDto;

/**
 * @author : sasha
 */
public interface INoticeTypeService {

    public RcNoticeTypeDto getById(int id);
    public RcNoticeTypeDto createUpdateNoticeType(RcNoticeTypeDto noticeType);
    public boolean deleteNoticeType(RcNoticeTypeDto noticeType);
}
