package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.relex.itschool.db.entity.RcRole;

/**
 * @author Anton
 *
 */

@Repository
public interface IRoleRepository extends JpaRepository<RcRole, Integer> {
}
