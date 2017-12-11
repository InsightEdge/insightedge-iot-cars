package com.magic;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

/**
 * @author Vitalii Zinchenko
 */
@SpaceClass
public class RemoveCarEventCopyEvent {

    private String id;

    private Integer carEventCopyId;

    public RemoveCarEventCopyEvent() {
    }

    public RemoveCarEventCopyEvent(Integer carEventCopyId) {
        this.carEventCopyId = carEventCopyId;
    }

    @SpaceId(autoGenerate = true)
    public String getId() {
        return id;
    }

    public RemoveCarEventCopyEvent setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getCarEventCopyId() {
        return carEventCopyId;
    }

    public RemoveCarEventCopyEvent setCarEventCopyId(Integer carEventCopyId) {
        this.carEventCopyId = carEventCopyId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemoveCarEventCopyEvent that = (RemoveCarEventCopyEvent) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return carEventCopyId != null ? carEventCopyId.equals(that.carEventCopyId) : that.carEventCopyId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (carEventCopyId != null ? carEventCopyId.hashCode() : 0);
        return result;
    }
}
