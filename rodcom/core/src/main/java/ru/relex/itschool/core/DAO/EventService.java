package ru.relex.itschool.core.DAO;

import ru.relex.itschool.core.model.Rc_event;


public interface EventService {

    void save(Rc_event e);
    void delete(Integer id);
}
