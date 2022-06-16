package com.ning.service.impl;

import com.ning.dao.RoomMapper;
import com.ning.entity.Room;
import com.ning.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {

    private RoomMapper roomMapper;

    public RoomMapper getRoomMapper() {
        return roomMapper;
    }

    public void setRoomMapper(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    public int addRoom(Room room) {
        return roomMapper.addRoom(room);
    }

    @Override
    public int deleteRoom(Room room) {
        return roomMapper.deleteRoom(room);
    }

    @Override
    public int updateRoom(Room room) {
        return roomMapper.updateRoom(room);
    }

    @Override
    public Room queryById(String roomId) {
        return roomMapper.queryById(roomId);
    }

    @Override
    public List<Room> queryAll() {
        return roomMapper.queryAll();
    }
}
