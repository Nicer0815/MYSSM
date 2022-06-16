package com.ning.dao;

import com.ning.entity.Checkin;

import java.util.List;

public interface CheckinMapper {
    int addCheckin(Checkin checkin);
    int deleteCheckin(Checkin checkin);
    Checkin queryById(String uuid);
    List<Checkin> queryAll();
    int updateCheckin(Checkin checkin);
}
