package ru.relex.itschool.services.service.impl;


import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcNoticeType;
import ru.relex.itschool.db.repository.IRcNoticeTypeRepository;
import ru.relex.itschool.services.modelDto.RcNoticeTypeDto;
import ru.relex.itschool.services.service.INoticeTypeService;
import ru.relex.itschool.services.util.ObjectBase;


/**
 * @author : sasha
 */
@Service
public class NoticeTypeServiceImpl implements INoticeTypeService {

    private final ObjectBase<RcNoticeType, IRcNoticeTypeRepository> noticeTypeObjectBase;

    public NoticeTypeServiceImpl(ObjectBase<RcNoticeType, IRcNoticeTypeRepository> noticeTypeObjectBase) {
        this.noticeTypeObjectBase = noticeTypeObjectBase;
    }

    @Override
    public RcNoticeTypeDto getById(int id) {
        RcNoticeType rcNoticeType = noticeTypeObjectBase.getByIdFromBase(id);
        if (noticeTypeObjectBase.isEmpty(rcNoticeType))

            //TODO Сделать нормальный обработчик возвращаемых значений из базы
            return null;
        return new RcNoticeTypeDto(rcNoticeType.getId(), rcNoticeType.getName());
    }

    @Override
    public RcNoticeTypeDto createUpdateNoticeType(RcNoticeTypeDto noticeTypeDto) {

        RcNoticeType rcNoticeType = noticeTypeObjectBase.getByIdFromBase(noticeTypeDto.getId());

        if (noticeTypeObjectBase.isEmpty(rcNoticeType)){
            rcNoticeType = new RcNoticeType(noticeTypeDto.getId(), noticeTypeDto.getName());
        }
        else {
            rcNoticeType.setName(noticeTypeDto.getName());
        }
        rcNoticeType = noticeTypeObjectBase.saveToRep(rcNoticeType);
        noticeTypeDto.setId(rcNoticeType.getId());
        return noticeTypeDto;
    }

    @Override
    public boolean deleteNoticeType(RcNoticeTypeDto noticeTypeDto) {

        RcNoticeType rcNoticeType = noticeTypeObjectBase.getByIdFromBase(noticeTypeDto.getId());
        if (noticeTypeObjectBase.isPresent(rcNoticeType)) {
            noticeTypeObjectBase.deleteFromRep(rcNoticeType);
            return true;
        }
        return false;
    }
}
