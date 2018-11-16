package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcNotice;
import ru.relex.itschool.db.entity.RcNoticeType;
import ru.relex.itschool.db.entity.RcSchool;
import ru.relex.itschool.db.repository.IRcNoticeRepository;
import ru.relex.itschool.db.repository.IRcNoticeTypeRepository;
import ru.relex.itschool.db.repository.IRcSchoolRepository;
import ru.relex.itschool.services.mapper.INoticeMapper;
import ru.relex.itschool.services.modelDto.RcNoticeDto;
import ru.relex.itschool.services.service.INoticeService;
import ru.relex.itschool.services.util.ObjectBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : sasha
 */
@Service
public class INoticeServiceImpl implements INoticeService {

    private final ObjectBase<RcNotice, IRcNoticeRepository> noticeObjectBase;
    private final ObjectBase<RcSchool, IRcSchoolRepository> schoolObjectBase;
    private final ObjectBase<RcNoticeType, IRcNoticeTypeRepository> noticeTypeObjectBase;
    private final INoticeMapper noticeMapper;

    public INoticeServiceImpl(ObjectBase<RcNotice, IRcNoticeRepository> noticeObjectBase, ObjectBase<RcSchool, IRcSchoolRepository> schoolObjectBase, ObjectBase<RcNoticeType, IRcNoticeTypeRepository> noticeTypeRepository, ObjectBase<RcNoticeType, IRcNoticeTypeRepository> noticeTypeObjectBase, INoticeMapper noticeMapper) {
        this.noticeObjectBase = noticeObjectBase;
        this.schoolObjectBase = schoolObjectBase;
        this.noticeTypeObjectBase = noticeTypeObjectBase;
        this.noticeMapper = noticeMapper;
    }

    @Override
    public RcNoticeDto getById(int id) {

        RcNotice rcNotice = noticeObjectBase.getByIdFromBase(id);
        if (noticeObjectBase.isEmpty(rcNotice))

            //TODO Сделать нормальный обработчик возвращаемых значений из базы
            return null;
        return noticeMapper.toDto(rcNotice);
    }

    @Override
    public RcNoticeDto createNotice(RcNoticeDto noticeDto) {

        RcNotice newNotice = noticeFromDto(noticeDto);
        newNotice = noticeObjectBase.saveToRep(newNotice);
        noticeDto.setId(newNotice.getId());
        return noticeDto;
    }


    @Override
    public RcNoticeDto updateNotice(RcNoticeDto noticeDto) {

        RcNotice rcNotice = noticeObjectBase.getByIdFromBase(noticeDto.getId());
        if (noticeObjectBase.isEmpty(rcNotice))
            return null;
        else
            rcNotice = noticeFromDto(noticeDto);

        rcNotice = noticeObjectBase.saveToRep(rcNotice);
        noticeDto.setId(rcNotice.getId());

        return noticeDto;
    }

    @Override
    public boolean deleteNotice(RcNoticeDto noticeDto) {

        RcNotice rcNotice = noticeObjectBase.getByIdFromBase(noticeDto.getId());
        if (noticeObjectBase.isPresent(rcNotice)){
            noticeObjectBase.deleteFromRep(rcNotice);
            return true;
        }
        return false;
    }

    @Override
    public List<RcNoticeDto> getNotices()
    {
        List<RcNoticeDto> noticesDto = new ArrayList<>();
        List<RcNotice> notices = noticeObjectBase.getListObject();

        return noticeMapper.toDto(notices);
    }

    private RcNotice noticeFromDto (RcNoticeDto noticeDto){

        RcNotice notice = noticeMapper.fromDto(noticeDto);
        notice.setSchool(schoolObjectBase.getByIdFromBase(noticeDto.getSchool()));
        notice.setType(noticeTypeObjectBase.getByIdFromBase(noticeDto.getType()));
        return notice;
    }
}
