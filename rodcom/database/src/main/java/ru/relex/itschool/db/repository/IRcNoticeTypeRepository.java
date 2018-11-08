package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcNoticeType;

/**
 * @author : sasha
 */
public interface IRcNoticeTypeRepository extends JpaRepository<RcNoticeType, Integer> {
}
