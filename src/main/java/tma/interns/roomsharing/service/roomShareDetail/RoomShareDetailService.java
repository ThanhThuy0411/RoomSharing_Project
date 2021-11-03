package tma.interns.roomsharing.service.roomShareDetail;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareCreateDetailDto;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareDetailDto;
import tma.interns.roomsharing.entity.RoomShareDetailEntity;
import tma.interns.roomsharing.enumration.ShareRole;
import tma.interns.roomsharing.mapper.IRoomShareDetailMapper;
import tma.interns.roomsharing.repository.RoomShareDetailRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoomShareDetailService implements IRoomShareDetailService{
    private  final RoomShareDetailRepo roomShareDetailRepo;
    private final IRoomShareDetailMapper roomShareDetailMapper;

    public RoomShareDetailService(RoomShareDetailRepo roomShareDetailRepo, IRoomShareDetailMapper roomShareDetailMapper) {
        this.roomShareDetailRepo = roomShareDetailRepo;
        this.roomShareDetailMapper = roomShareDetailMapper;
    }

    /**
     * Create room sharing detail
     *
     * @author tt0411
     * @param roomShareCreateDetailDto
     * @return room sharing create detail
     * @throws Exception
     */
    public RoomShareDetailDto createDetail(RoomShareCreateDetailDto roomShareCreateDetailDto) throws Exception {
        RoomShareDetailEntity getEntity = roomShareDetailRepo.findFirstByUserId(roomShareCreateDetailDto.getUserId());
        if(getEntity != null) throw new Exception("User ID da ton tai");
        RoomShareDetailEntity roomShareDetailEntity = roomShareDetailMapper.fromCreateDtoToEntity(roomShareCreateDetailDto);
        RoomShareDetailEntity returnShareDetail = roomShareDetailRepo.save(roomShareDetailEntity);
        return roomShareDetailMapper.toDetailDto(returnShareDetail);
    }

    /**
     * delete room sharing detail
     *
     * @author tt0411
     * @param roomShareDetailId
     * @return status 200
     */
    public boolean delete(UUID roomShareDetailId) {
        RoomShareDetailEntity roomShareDetailEntity =roomShareDetailRepo.findFirstByRoomShareDetailId(roomShareDetailId);
        if(roomShareDetailEntity != null){
            roomShareDetailRepo.deleteById(roomShareDetailId);
            return true;
        }
        return false;
    }

    /**
     * list all by room sharing id
     *
     * @author tt0411
     * @param roomSharingId
     * @return list room sharing detail by room sharing id
     */
    public List<RoomShareDetailDto> listAllByRoomSharingId(UUID roomSharingId) {
        List<RoomShareDetailEntity> details = roomShareDetailRepo.findFirstByRoomSharingId(roomSharingId);
        if( details.size()>0){
            return roomShareDetailMapper.toDetailDtos(details);
        }
        return new ArrayList<>();
    }

    /**
     * join room sharing detail with capacity member
     *
     * @author hienle
     * @param roomShareCreateDetailDto
     * @param roomSharingId
     * @return room sharing detail
     * @throws Exception
     */
    public RoomShareDetailDto joinByRoomSharingId (RoomShareCreateDetailDto roomShareCreateDetailDto, UUID roomSharingId) throws Exception {
        RoomShareDetailEntity getEntity = roomShareDetailRepo.findFirstByUserId(roomShareCreateDetailDto.getUserId());
        if(getEntity != null) throw new Exception("User ID da ton tai");
        RoomShareDetailEntity roomShareDetailEntity = roomShareDetailMapper.fromCreateDtoToEntity(roomShareCreateDetailDto);
        roomShareDetailEntity.setRole(ShareRole.Member);
        roomShareDetailEntity = roomShareDetailRepo.save(roomShareDetailEntity);
        return roomShareDetailMapper.toDetailDto(roomShareDetailEntity);
    }
}
