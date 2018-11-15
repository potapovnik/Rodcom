package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcNotice;
import ru.relex.itschool.db.entity.RcNoticeType;
import ru.relex.itschool.db.entity.RcSchool;
import ru.relex.itschool.db.repository.IRcNoticeRepository;
import ru.relex.itschool.db.repository.IRcNoticeTypeRepository;
import ru.relex.itschool.db.repository.IRcSchoolRepository;
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

    public INoticeServiceImpl(ObjectBase<RcNotice, IRcNoticeRepository> noticeObjectBase, ObjectBase<RcSchool, IRcSchoolRepository> schoolObjectBase, ObjectBase<RcNoticeType, IRcNoticeTypeRepository> noticeTypeRepository, ObjectBase<RcNoticeType, IRcNoticeTypeRepository> noticeTypeObjectBase) {
        this.noticeObjectBase = noticeObjectBase;
        this.schoolObjectBase = schoolObjectBase;
        this.noticeTypeObjectBase = noticeTypeObjectBase;
    }

    @Override
    public RcNoticeDto getById(int id) {

        RcNotice rcNotice = noticeObjectBase.getByIdFromBase(id);
        if (noticeObjectBase.isEmpty(rcNotice))

            //TODO Сделать нормальный обработчик возвращаемых значений из базы
            return null;
        return new RcNoticeDto(rcNotice.getId(), rcNotice.getSchool().getSchool_id(), rcNotice.getType().getId(), rcNotice.getDate(), rcNotice.getText(), rcNotice.getAgenda());
    }

    @Override
    public RcNoticeDto createNotice(RcNoticeDto noticeDto) {

        RcNotice rcNotice = new RcNotice();
        rcNotice.setSchool(schoolObjectBase.getByIdFromBase(noticeDto.getSchool()));
        rcNotice.setType(noticeTypeObjectBase.getByIdFromBase(noticeDto.getType()));
        rcNotice.setDate(noticeDto.getDate());
        rcNotice.setText(noticeDto.getText());
        rcNotice.setAgenda(noticeDto.getAgenda());
        rcNotice = noticeObjectBase.saveToRep(rcNotice);
        noticeDto.setId(rcNotice.getId());
        return noticeDto;
    }


    @Override
    public RcNoticeDto updateNotice(RcNoticeDto noticeDto) {

        RcNotice rcNotice = noticeObjectBase.getByIdFromBase(noticeDto.getId());
        if (noticeObjectBase.isEmpty(rcNotice))
            return null;
            /*rcNotice = new RcNotice(schoolObjectBase.getByIdFromBase(noticeDto.getSchool()),
                    noticeTypeObjectBase.getByIdFromBase(noticeDto.getType()),
                    noticeDto.getDate(),
                    noticeDto.getText(),
                    noticeDto.getAgenda());*/
        else{
            rcNotice.setSchool(schoolObjectBase.getByIdFromBase(noticeDto.getSchool()));
            rcNotice.setType(noticeTypeObjectBase.getByIdFromBase(noticeDto.getType()));
            rcNotice.setDate(noticeDto.getDate());
            rcNotice.setText(noticeDto.getText());
            rcNotice.setAgenda(noticeDto.getAgenda());
        }
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
        //TODO тут пока ничего не делается. Надо сделать!!!!
        return noticesDto;
    }
}
