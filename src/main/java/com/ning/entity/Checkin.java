package com.ning.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Checkin)实体类
 *
 * @author makejava
 * @since 2022-06-16 14:28:18
 */
public class Checkin implements Serializable {
    private static final long serialVersionUID = -60388755331493351L;
    /**
     * （一起开房的人此字段相同）格式：yyyy-MM-dd-num
     */
    private String checkinId;
    
    private String roomId;
    
    private String customerId;
    /**
     * 真实入住时间
     */
    private Date checkinDate;
    /**
     * 真实退房时间
     */
    private Date leaveDate;
    
    private String state;
    /**
     * 入住人数
     */
    private Integer number;
    
    private Integer uuid;


    public String getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(String checkinId) {
        this.checkinId = checkinId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

}

