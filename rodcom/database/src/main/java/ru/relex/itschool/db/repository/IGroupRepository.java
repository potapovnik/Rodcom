package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcGroup;

/**
 * @author Anton
 *
 */

public interface IGroupRepository extends JpaRepository<RcGroup, Integer> {

}
