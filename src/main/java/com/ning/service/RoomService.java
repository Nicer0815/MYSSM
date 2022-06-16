package com.ning.service;

import com.ning.entity.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {
    int addRoom(Room room);
    int deleteRoom(Room room);
    int updateRoom(Room room);
    Room queryById(String roomId);
    List<Room> queryAll();
}
