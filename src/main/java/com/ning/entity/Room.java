package com.ning.entity;

import java.io.Serializable;

/**
 * (Room)实体类
 *
 * @author makejava
 * @since 2022-06-16 14:29:15
 */
public class Room implements Serializable {
    private static final long serialVersionUID = -53368864116188445L;
    
    private String roomId;
    private String size;
    private String state;
    private Integer price;


    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Room() {
    }

    public Room(String roomId, String size, String state, Integer price) {
        this.roomId = roomId;
        this.size = size;
        this.state = state;
        this.price = price;
    }
}

