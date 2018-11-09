package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.services.service.IInsertToDbInit;

//import java.util.Calendar;
//import java.util.Date;

/**
 * @author : sasha
 */
@Service
public class InsertToDbInitImpl implements IInsertToDbInit {
    public void DbInit() {
/*
        Rc_school school = new Rc_school("МБОУ СОШ №123");

        Rc_member member = new Rc_member("Председатель родительского комитета", new Date(), "Иван", "Иванович", "Иванов", "+7-903-111-11-11", "222-22-22",
                "г. Воронеж, ул. Бахметьева, д. 2б", "ivanov@relex.ru", "ivanovii", "vk_ivanov", "ok_ivanov", "twit_ivanov");


        Rc_role role = new Rc_role();
        role.setRoleName("role");


        Rc_group group = new Rc_group();
        group.setSchool(school);
        group.setGroupType("group type");
        group.setGroupName("group name");
        group.setGroupDesc("group description");
        group.setEnabled(true);


        Rc_message message = new Rc_message("test message", "text for test message", new Date(), "urgent");
        message.setTo_member(member);
        message.setFrom_member(member);
        message.setTo_group(group);


        Rc_group_member group_member = new Rc_group_member(group.getGroupId(), member.getMember_id(), role.getRoleId(), true, true);


        RcNoticeType noticeType = new RcNoticeType(1, "информация");



        Calendar calendar = Calendar.getInstance();
        RcNotice notice = new RcNotice(school, noticeType, calendar, "Внимание!", "");

        */
    }
}
