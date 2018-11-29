package ru.relex.itschool.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.db.entity.RcMessage;
import ru.relex.itschool.db.entity.RcGroup;
import java.util.List;

public interface IRcMessageRepository extends JpaRepository<RcMessage, Integer> {
    List<RcMessage> findByToGroup(RcGroup group, Sort sort);
    List<RcMessage> findByToMember(RcMember member, Sort sort);
    List<RcMessage> findByFromMember(RcMember member, Sort sort);
}
