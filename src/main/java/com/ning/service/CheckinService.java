package com.ning.service;

import com.ning.entity.Checkin;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface CheckinService {
    int addCheckin(Checkin checkin);
    int deleteCheckin(Checkin checkin);
    Checkin queryById(String uuid);
    List<Checkin> queryAll();
    int updateCheckin(Checkin checkin);

    List<Checkin> queryToday(Date today);
}
