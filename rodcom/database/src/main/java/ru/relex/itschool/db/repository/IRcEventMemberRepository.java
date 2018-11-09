package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcEventMember;

public interface IRcEventMemberRepository extends JpaRepository <RcEventMember,Integer> {
}
