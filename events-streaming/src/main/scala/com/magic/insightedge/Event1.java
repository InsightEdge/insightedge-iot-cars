package com.magic.insightedge;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

/**
 * @author Vitalii Zinchenko
 */
@SpaceClass
public class Event1 {

    private Integer id;

    public Event1() {
    }

    public Event1(Integer id) {
        this.id = id;
    }

    @SpaceId
    public Integer getId() {
        return id;
    }

    public Event1 setId(Integer id) {
        this.id = id;
        return this;
    }
}
