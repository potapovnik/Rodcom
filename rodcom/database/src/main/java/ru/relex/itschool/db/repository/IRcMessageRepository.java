package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcMessage;

public interface IRcMessageRepository extends JpaRepository<RcMessage, Integer> {
}
