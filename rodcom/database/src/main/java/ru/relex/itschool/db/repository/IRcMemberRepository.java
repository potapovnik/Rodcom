package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcMember;

public interface IRcMemberRepository extends JpaRepository<RcMember, Integer> {
}
