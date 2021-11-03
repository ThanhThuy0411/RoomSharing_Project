package tma.interns.roomsharing.dto.room;

import lombok.Data;
import tma.interns.roomsharing.entity.RoomInfoEntity;
import tma.interns.roomsharing.enumration.StatusType;

import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

@Data
public class SearchRoomDto {
    private UUID provinceId;
    private UUID districtId;
    private UUID wardId;
    private Float fromAcreage;
    private Float toAcreage;
    private Integer fromRoomPrice;
    private Integer toRoomPrice;
    private String statusHired;
    private Date date;
    private String orderBy;
    private Boolean asc;

    public String getSortType() {
        return asc ? "ASC" : "DESC";
    }

    public Comparator<RoomInfoEntity> getSearchBy() {
        Comparator<RoomInfoEntity> comparator = Comparator.comparing(RoomInfoEntity::getDate);
        switch (orderBy) {
            case "date":
                comparator = Comparator.comparing(RoomInfoEntity::getDate);
            case "roomPrice":
                comparator = Comparator.comparing(RoomInfoEntity::getRoomPrice);
            case "acreage":
                comparator = Comparator.comparing(RoomInfoEntity::getAcreage);
        }
        return asc ? comparator : comparator.reversed();
    }

    public StatusType getValueStatusHired() {
        try {
            return StatusType.valueOf(this.statusHired);
        } catch (Exception e) {
            return null;
        }
    }
}
