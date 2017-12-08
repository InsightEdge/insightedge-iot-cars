package com.magic.insightedge;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

/**
 * @author Vitalii Zinchenko
 */
@SpaceClass
public class Event2 {

    private Integer id;

    public Event2() {
    }

    public Event2(Integer id) {
        this.id = id;
    }

    @SpaceId
    public Integer getId() {
        return id;
    }

    public Event2 setId(Integer id) {
        this.id = id;
        return this;
    }
}
