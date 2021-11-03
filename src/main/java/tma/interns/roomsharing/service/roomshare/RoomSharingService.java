package tma.interns.roomsharing.service.roomshare;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareCreateDetailDto;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareDetailDto;
import tma.interns.roomsharing.dto.roomshare.RoomSharingDto;
import tma.interns.roomsharing.entity.RoomSharingEntity;
import tma.interns.roomsharing.enumration.ShareRole;
import tma.interns.roomsharing.mapper.IRoomSharingMapper;
import tma.interns.roomsharing.repository.RoomSharingRepo;
import tma.interns.roomsharing.service.roomShareDetail.IRoomShareDetailService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoomSharingService implements IRoomSharingService{
    private final RoomSharingRepo roomSharingRepo;
    private final IRoomSharingMapper roomSharingMapper;
    private final IRoomShareDetailService roomShareDetailService;

    public RoomSharingService(RoomSharingRepo roomSharingRepo, IRoomSharingMapper roomSharingMapper, IRoomShareDetailService roomShareDetailService) {
        this.roomSharingRepo = roomSharingRepo;
        this.roomSharingMapper = roomSharingMapper;
        this.roomShareDetailService = roomShareDetailService;
    }

    /**
     *Create Room sharing
     *
     * @author tt0411
     * @param roomSharing
     * @return Room sharing and Room sharing detail with owner room sharing detail
     * @throws Exception
     */
    public RoomSharingDto newRoomSharing(RoomSharingDto roomSharing) throws Exception {
        RoomSharingEntity roomSharingEntity = roomSharingMapper.fromSharingDtoToEntity(roomSharing);
        roomSharingEntity = roomSharingRepo.save(roomSharingEntity);
        roomShareDetailService.createDetail(RoomShareCreateDetailDto.builder().
                roomSharingId(roomSharingEntity.getRoomSharingId()).role(ShareRole.Key).build());
        List<RoomShareDetailDto> details = roomShareDetailService.listAllByRoomSharingId(roomSharingEntity.getRoomSharingId());
        RoomSharingDto roomSharingDto =  roomSharingMapper.toRoomSharingDto(roomSharingEntity);
        roomSharingDto.setRoomShareDetails(details);
        return roomSharingDto;
    }

    /**
     * list all Room sharing
     *
     * @author tt0411
     * @return list room sharing
     */
    @Override
    public List<RoomSharingDto> listAll() {
        List<RoomSharingEntity> roomSharingList = roomSharingRepo.findAll();
        if( roomSharingList.size()>0){
            return roomSharingMapper.toRoomSharingDtos(roomSharingList);
        }
        return new ArrayList<>();
    }

    /**
     * get room sharing by room sharing id
     *
     * @author tt0411
     * @param roomSharingId
     * @return room sharing
     */
    @Override
    public RoomSharingDto getById(UUID roomSharingId) {
        RoomSharingEntity roomSharingEntity = roomSharingRepo.findFirstByRoomSharingId(roomSharingId);
        if(roomSharingEntity != null) {
            return roomSharingMapper.toRoomSharingDto(roomSharingEntity);
        }
        return null;
    }

    /**
     * delete room sharing by room sharing id
     *
     * @author hlee
     * @param roomSharingId
     * @return status 200
     */
    @Override
    public boolean delete(UUID roomSharingId){
        RoomSharingEntity roomSharingEntity= roomSharingRepo.findFirstByRoomSharingId(roomSharingId);
        if(roomSharingEntity != null){
            roomSharingRepo.deleteById(roomSharingId);
            return true;
        }
        return false;
    }
}
