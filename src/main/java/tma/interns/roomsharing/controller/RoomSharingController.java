package tma.interns.roomsharing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareCreateDetailDto;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareDetailDto;
import tma.interns.roomsharing.dto.roomshare.RoomSharingDto;
import tma.interns.roomsharing.service.roomShareDetail.IRoomShareDetailService;
import tma.interns.roomsharing.service.roomshare.IRoomSharingService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class RoomSharingController {
    private final IRoomSharingService roomSharingService;
    private final IRoomShareDetailService roomShareDetailService;

    public RoomSharingController(IRoomSharingService roomSharingService, IRoomShareDetailService roomShareDetailService) {
        this.roomSharingService = roomSharingService;
        this.roomShareDetailService = roomShareDetailService;
    }

    @PostMapping("/sharing")
    public ResponseEntity<RoomSharingDto> newRoomSharing(@RequestBody RoomSharingDto newSharing) throws Exception {
        try {
            RoomSharingDto created = roomSharingService.newRoomSharing(newSharing);
            return new ResponseEntity<>(created, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/sharing/detail/{roomSharingId}")
    public ResponseEntity<RoomShareDetailDto> join(@RequestBody RoomShareCreateDetailDto joinMember, @PathVariable UUID roomSharingId) throws Exception {
        try {
            RoomShareDetailDto joined = roomShareDetailService.joinByRoomSharingId(joinMember, roomSharingId);
            return new ResponseEntity<>(joined, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/sharing/detail/{roomShareDetailId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID roomShareDetailId) {
        try {
            roomShareDetailService.delete(roomShareDetailId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sharing")
    public ResponseEntity<List<RoomSharingDto>> listAll() {
        try {
            List<RoomSharingDto> roomSharingDtoList = roomSharingService.listAll();
            return new ResponseEntity<>(roomSharingDtoList, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sharing/{roomSharingId}")
    public ResponseEntity<RoomSharingDto> getRoomSharing(@PathVariable UUID roomSharingId) {
        try {
            RoomSharingDto roomSharingDto = roomSharingService.getById(roomSharingId);
            return new ResponseEntity<>(roomSharingDto, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/sharing/{roomSharingId}")
    public ResponseEntity<HttpStatus> deleteSharing(@PathVariable UUID roomSharingId) {
        try {
                roomSharingService.delete(roomSharingId);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch (Exception ex){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
