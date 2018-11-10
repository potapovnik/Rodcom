package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcNotice;

/**
 * @author : sasha
 *
 */
public interface IRcNoticeRepository extends JpaRepository<RcNotice, Integer> {
}
