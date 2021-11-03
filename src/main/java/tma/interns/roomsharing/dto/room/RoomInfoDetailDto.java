package tma.interns.roomsharing.dto.room;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tma.interns.roomsharing.dto.file.FileDto;
import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.enumration.RoomType;
import tma.interns.roomsharing.enumration.StatusType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.UUID;
import java.util.List;

@Data
public class RoomInfoDetailDto {
    private UUID roomId;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private UUID userId;
    private UUID provinceId;
    private UUID districtId;
    private UUID wardId;
    private String address;
    private Float acreage;
    private Integer roomPrice;
    private String roomDescribe;
    @Enumerated(EnumType.STRING)
    private StatusType statusHired;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date date;
    private String title;
    private UserBasicDto user;
    private List<FileDto> files;
}
