package com.ning.dao;

import com.ning.entity.Room;

import java.util.List;

public interface RoomMapper {
    int addRoom(Room room);
    int deleteRoom(Room room);
    int updateRoom(Room room);
    Room queryById(String roomId);
    List<Room> queryAll();
    List<Room> queryRest();
    List<Room> queryBusy();
    List<Room> queryFix();
}
