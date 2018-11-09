package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.relex.itschool.db.entity.RcGroup;

/**
 * @author Anton
 *
 */

@Repository
public interface IGroupRepository extends JpaRepository<RcGroup, Integer> {

}
