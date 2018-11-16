package ru.relex.itschool.services.service.impl;


import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcNoticeType;
import ru.relex.itschool.db.repository.IRcNoticeTypeRepository;
import ru.relex.itschool.services.mapper.INoticeTypeMapper;
import ru.relex.itschool.services.modelDto.RcNoticeTypeDto;
import ru.relex.itschool.services.service.INoticeTypeService;
import ru.relex.itschool.services.util.ObjectBase;


/**
 * @author : sasha
 */
@Service
public class NoticeTypeServiceImpl implements INoticeTypeService {

    private final ObjectBase<RcNoticeType, IRcNoticeTypeRepository> noticeTypeObjectBase;
    private final INoticeTypeMapper noticeTypeMapper;

    public NoticeTypeServiceImpl(ObjectBase<RcNoticeType, IRcNoticeTypeRepository> noticeTypeObjectBase, INoticeTypeMapper noticeTypeMapper) {
        this.noticeTypeObjectBase = noticeTypeObjectBase;
        this.noticeTypeMapper = noticeTypeMapper;
    }

    @Override
    public RcNoticeTypeDto getById(int id) {
        RcNoticeType rcNoticeType = noticeTypeObjectBase.getByIdFromBase(id);
        if (noticeTypeObjectBase.isEmpty(rcNoticeType))

            //TODO Сделать нормальный обработчик возвращаемых значений из базы
            return null;
        return noticeTypeMapper.toDto(rcNoticeType);
    }

    @Override
    public RcNoticeTypeDto createUpdateNoticeType(RcNoticeTypeDto noticeTypeDto) {

        RcNoticeType rcNoticeType = noticeTypeObjectBase.getByIdFromBase(noticeTypeDto.getId());

        if (noticeTypeObjectBase.isEmpty(rcNoticeType)){
            rcNoticeType = noticeTypeMapper.fromDto(noticeTypeDto);
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
