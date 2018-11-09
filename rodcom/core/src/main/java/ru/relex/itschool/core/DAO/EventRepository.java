package ru.relex.itschool.core.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.relex.itschool.core.model.Rc_event;

import java.util.List;


public interface EventRepository extends JpaRepository<Rc_event,Integer> {
}
