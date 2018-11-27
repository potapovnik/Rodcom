package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.relex.itschool.db.entity.RcMember;

import java.util.Optional;

public interface IRcMemberRepository extends JpaRepository<RcMember, Integer> {
    @Query("SELECT m FROM RcMember m WHERE m.email = :email")
    Optional<RcMember> findByEmail(@Param("email") String email);
}
