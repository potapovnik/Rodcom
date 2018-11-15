package ru.relex.itschool.services.modelDto;

import ru.relex.itschool.db.entity.RcNotice;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : sasha
 */
public class RcNoticeTypeDto {

    private int id;
    private String name;

    public RcNoticeTypeDto() {
    }

    public RcNoticeTypeDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
