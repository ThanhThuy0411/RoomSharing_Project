package tma.interns.roomsharing.service.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.file.FileDto;
import tma.interns.roomsharing.dto.room.RoomInfoBasicDto;
import tma.interns.roomsharing.dto.room.RoomInfoCreateDto;
import tma.interns.roomsharing.dto.room.RoomInfoDetailDto;
import tma.interns.roomsharing.entity.RoomInfoEntity;
import tma.interns.roomsharing.enumration.FileParentType;
import tma.interns.roomsharing.enumration.FileType;
import tma.interns.roomsharing.mapper.IRoomInfoMapper;
import tma.interns.roomsharing.repository.RoomInfoRepository;
import tma.interns.roomsharing.service.file.FileService;
import tma.interns.roomsharing.util.JwtUtil;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class RoomInfoService implements IRoomInfoService {
    private final  RoomInfoRepository roomRepo;
    private final FileService fileService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    private final IRoomInfoMapper roomMapper;
    public RoomInfoService(RoomInfoRepository roomRepo, IRoomInfoMapper roomMapper,
                           FileService fileService){
        this.roomRepo = roomRepo;
        this.roomMapper = roomMapper;
        this.fileService = fileService;
    }

    /**
     * list All RoomInfo
     *
     * @author hienle
     * @return
     */
    public List<RoomInfoBasicDto> listAll() {
            List<RoomInfoEntity> listRoom = roomRepo.findAll();
            List<RoomInfoBasicDto> roomInfoBasicDtos = new ArrayList<>();
            for (RoomInfoEntity room : listRoom) {
                RoomInfoBasicDto roomInfoBasicDto = roomMapper.toBasicDto(room);
                roomInfoBasicDto.setFiles(
                        fileService.getByParentTypeAndParentId(FileParentType.Room.getValue(), room.getRoomId()));
                roomInfoBasicDtos.add(roomInfoBasicDto);
            }
        return roomInfoBasicDtos;
        }

    /**
     * get By roomId
     *
     * @author hienle
     * @param roomId
     * @return roomInfo by roomId
     */
    public RoomInfoDetailDto getById(UUID roomId){
        RoomInfoEntity roomInfoEntity = roomRepo.findFirstByRoomId(roomId);
        if(roomInfoEntity != null) {
            RoomInfoDetailDto result = roomMapper.toDetailDto(roomInfoEntity);
            List<FileDto> listFiles = fileService.getByParentTypeAndParentId(FileParentType.Room.getValue(), roomId);
            result.setFiles(listFiles);
            return result;
        }
        else {
            return null;
        }
    }

    /**
     * delete by roomId
     *
     * @author hienle
     * @param roomId
     * @return status 200
     */
    public boolean delete(UUID roomId){
        RoomInfoEntity roomInfoEntity = roomRepo.findFirstByRoomId(roomId);
        if(roomInfoEntity != null){
            roomRepo.deleteByRoomId(roomId);
            fileService.deleteByParentTypeAndParentId(FileParentType.Room.getValue(), roomId);
            fileService.deleteByParentTypeAndParentId(FileParentType.Room.getValue(), roomId);
            return true;
        }
        return false;
    }

    /**
     * update RoomInfo by roomId
     *
     * @author hienle
     * @param dto
     * @param roomId
     * @return new roomInfo
     * @throws Exception
     */
    public RoomInfoDetailDto updateRoomInfo (RoomInfoDetailDto dto, UUID roomId) throws Exception {
        RoomInfoEntity roomInfoEntity = roomMapper.fromBasicToEntity(dto);
        roomInfoEntity.setRoomId(roomId);
        if(roomInfoEntity.getAcreage()==null||roomInfoEntity.getAddress()==null||roomInfoEntity.getProvinceId()==null||
                roomInfoEntity.getDistrictId()==null||roomInfoEntity.getWardId()==null||roomInfoEntity.getRoomDescribe()==null||
                roomInfoEntity.getRoomPrice()==null||roomInfoEntity.getStatusHired()==null)
            throw new Exception ("");
        RoomInfoEntity returnRoom = roomRepo.saveAndFlush(roomInfoEntity);
        fileService.deleteByParentTypeAndParentId(FileParentType.Room.getValue(), roomId);
        fileService.deleteByParentTypeAndParentId(FileParentType.Room.getValue(), roomId);
        dto.getFiles().forEach((file) -> {
            file.setParentType(FileParentType.Room.getValue());
            file.setParentId(returnRoom.getRoomId());
            file.setType(FileType.Image);
            fileService.createFile(file);
        });
        return roomMapper.toDetailDto(returnRoom);
    }

    /**
     * create RoomInfo
     *
     * @author hienle
     * @param rooms
     * @return roomInfo
     * @throws Exception
     */
    @Override
    public RoomInfoDetailDto createRoomInfo(RoomInfoCreateDto rooms) throws Exception {
        rooms.setDate((new Date()));
        RoomInfoEntity roomInfoEntity = roomMapper.fromCreateToEntity(rooms);
        if (roomInfoEntity.getAcreage() == null || roomInfoEntity.getAddress() == null || roomInfoEntity.getProvinceId() == null ||
                roomInfoEntity.getDistrictId() == null || roomInfoEntity.getWardId() == null || roomInfoEntity.getRoomDescribe() == null ||
                roomInfoEntity.getRoomPrice() == null || roomInfoEntity.getStatusHired() == null)
            throw new Exception("");
        RoomInfoEntity returnRoom = roomRepo.save(roomInfoEntity);
        rooms.getFiles().forEach((file) -> {
            file.setParentType(FileParentType.Room.getValue());
            file.setParentId(returnRoom.getRoomId());
            file.setType(FileType.Image);
            fileService.createFile(file);
        });
        return roomMapper.toDetailDto(returnRoom);
    }
}
