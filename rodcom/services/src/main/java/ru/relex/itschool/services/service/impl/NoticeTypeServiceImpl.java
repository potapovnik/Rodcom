package ru.relex.itschool.services.service.impl;


import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcNoticeType;
import ru.relex.itschool.db.repository.IRcNoticeTypeRepository;
import ru.relex.itschool.services.modelDto.RcNoticeTypeDto;
import ru.relex.itschool.services.service.INoticeTypeService;

import java.util.Optional;

/**
 * @author : sasha
 */
@Service
public class NoticeTypeServiceImpl implements INoticeTypeService {

    private final IRcNoticeTypeRepository repository;

    public NoticeTypeServiceImpl(IRcNoticeTypeRepository noticeTypeRepository) {
        this.repository = noticeTypeRepository;
    }

    @Override
    public RcNoticeTypeDto getById(int id) {
        RcNoticeType rcNoticeType = getByIdFromBase(id);
        if (!isPresent(rcNoticeType))

            //TODO Сделать нормальный обработчик возвращаемых значений из базы
            return null;
        return new RcNoticeTypeDto(rcNoticeType.getId(), rcNoticeType.getName());
    }

    @Override
    public RcNoticeTypeDto createUpdateNoticeType(RcNoticeTypeDto noticeTypeDto) {

        RcNoticeType rcNoticeType = getByIdFromBase(noticeTypeDto.getId());

        if (!isPresent(rcNoticeType)){
            rcNoticeType = new RcNoticeType(noticeTypeDto.getId(), noticeTypeDto.getName());
        }
        else {
            rcNoticeType.setName(noticeTypeDto.getName());
        }
        rcNoticeType = repository.save(rcNoticeType);
        noticeTypeDto.setId(rcNoticeType.getId());
        return noticeTypeDto;
    }

    @Override
    public boolean deleteNoticeType(RcNoticeTypeDto noticeTypeDto) {

        RcNoticeType rcNoticeType = getByIdFromBase(noticeTypeDto.getId());
        if (isPresent(rcNoticeType)) {
            repository.delete(rcNoticeType);
            return true;
        }
        return false;
    }

    private RcNoticeType getByIdFromBase (int id){
        Optional<RcNoticeType> optional = repository.findById(id);
        if (!optional.isPresent())
            return null;
        RcNoticeType noticeType = optional.get();
        return noticeType;
    }

    private boolean isPresent(RcNoticeType rcNoticeType){
        if (rcNoticeType == null)
            return false;
        else
            return true;
    }
}
