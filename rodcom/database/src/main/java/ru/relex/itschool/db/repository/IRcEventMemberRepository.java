package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcEventMember;
import ru.relex.itschool.db.entity.RcMember;

import java.util.List;

public interface IRcEventMemberRepository extends JpaRepository <RcEventMember,Integer> {
/*    List<RcEventMember> findByToMember(RcMember member);*/
}
