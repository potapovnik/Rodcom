package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcGroupMember;

import java.util.List;

public interface IRcGroupMemberRepository extends JpaRepository <RcGroupMember,Integer> {
    List<RcGroupMember> findByGroupId(int groupId);
    List<RcGroupMember> findByRoleId(int roleId);
}
