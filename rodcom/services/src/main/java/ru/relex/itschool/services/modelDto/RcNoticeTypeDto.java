package ru.relex.itschool.services.modelDto;

import ru.relex.itschool.db.entity.RcNotice;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : sasha
 */
public class RcNoticeTypeDto {

    private Integer id;
    private String name;

    public RcNoticeTypeDto() {
    }

    public RcNoticeTypeDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
