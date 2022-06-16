package com.ning.dao;

import com.ning.entity.Checkin;
import com.ning.entity.Customer;

import java.util.Date;
import java.util.List;

public interface CheckinMapper {
    int addCheckin(Checkin checkin);
    int deleteCheckin(Checkin checkin);
    Checkin queryById(String uuid);
    List<Checkin> queryAll();
    int updateCheckin(Checkin checkin);

    List<Checkin> queryToday(Date today);
    List<Checkin> queryTodayLeave(Date today);
}
