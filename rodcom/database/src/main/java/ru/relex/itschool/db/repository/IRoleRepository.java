package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.itschool.db.entity.RcRole;

public interface IRoleRepository extends JpaRepository<RcRole, Integer> {
}
