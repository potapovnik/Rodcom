package ru.relex.itschool.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.relex.itschool.db.entity.RcNotice;
import ru.relex.itschool.db.entity.RcNoticeType;
import ru.relex.itschool.db.entity.RcSchool;
import ru.relex.itschool.db.repository.IRcNoticeRepository;
import ru.relex.itschool.db.repository.IRcNoticeTypeRepository;
import ru.relex.itschool.db.repository.IRcSchoolRepository;
import ru.relex.itschool.services.util.ObjectBase;

/**
 * @author : sasha
 *
 * Создание объектов_из_базы
 * "new в коде это плохо!(с)"
 * Реализуем DI :)
 */
@Configuration
public class ObjectBaseConfig {

    private final IRcNoticeRepository noticeRepository;
    private final IRcNoticeTypeRepository noticeTypeRepository;
    private final IRcSchoolRepository schoolRepository;

    public ObjectBaseConfig(IRcNoticeRepository noticeRepository, IRcNoticeTypeRepository noticeTypeRepository, IRcSchoolRepository schoolRepository) {
        this.noticeRepository = noticeRepository;
        this.noticeTypeRepository = noticeTypeRepository;
        this.schoolRepository = schoolRepository;
    }


    @Bean
    ObjectBase<RcNotice, IRcNoticeRepository> noticeObjectBase() { return new ObjectBase<>(noticeRepository);}

    @Bean
    ObjectBase<RcNoticeType, IRcNoticeTypeRepository> noticeTypeObjectBase() { return new ObjectBase<>(noticeTypeRepository);}

    @Bean
    ObjectBase<RcSchool, IRcSchoolRepository> schoolObjectBase() {return new ObjectBase<>(schoolRepository);}
}
