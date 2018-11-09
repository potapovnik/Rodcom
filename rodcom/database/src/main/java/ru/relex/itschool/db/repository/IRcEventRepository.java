package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcEvent;

public interface IRcEventRepository extends JpaRepository <RcEvent,Integer> {
}
