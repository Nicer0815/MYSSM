package com.ning.service.impl;

import com.ning.dao.CheckinMapper;
import com.ning.entity.Checkin;
import com.ning.service.CheckinService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CheckinServiceImpl implements CheckinService {

    private CheckinMapper checkinMapper;

    public CheckinMapper getCheckinMapper() {
        return checkinMapper;
    }

    public void setCheckinMapper(CheckinMapper checkinMapper) {
        this.checkinMapper = checkinMapper;
    }

    @Override
    public int addCheckin(Checkin checkin) {
        return checkinMapper.addCheckin(checkin);
    }

    @Override
    public int deleteCheckin(Checkin checkin) {
        return checkinMapper.deleteCheckin(checkin);
    }

    @Override
    public Checkin queryById(String UUID) {
        return checkinMapper.queryById(UUID);
    }

    @Override
    public List<Checkin> queryAll() {
        return checkinMapper.queryAll();
    }

    @Override
    public int updateCheckin(Checkin checkin) {
        return checkinMapper.updateCheckin(checkin);
    }

    @Override
    public List<Checkin> queryToday(Date today) {
        return checkinMapper.queryToday(today);
    }
}
