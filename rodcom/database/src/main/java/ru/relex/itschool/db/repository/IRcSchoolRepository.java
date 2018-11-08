package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcSchool;

public interface IRcSchoolRepository extends JpaRepository<RcSchool, Integer> {
}
