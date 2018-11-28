package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcEvent;
import ru.relex.itschool.db.entity.RcEventMember;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.db.entity.RcMessage;

import java.util.List;

public interface IRcEventMemberRepository extends JpaRepository <RcEventMember,Integer> {

}
