package com.example.servicehi.service.impl;

import com.example.servicehi.dao.IpAddressDao;
import com.example.servicehi.entity.IpAddress;
import com.example.servicehi.service.IpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IpAddressServiceImpl<T extends IpAddress> implements IpAddressService<T> {
    @Autowired
    private IpAddressDao<T> ipAddressDao;

    @Override
    public T selectMac(T t) {
        return ipAddressDao.selectMac(t);
    }

    @Override
    public void updateIP() {
        ipAddressDao.updateIP();
    }

    @Override
    public void insert(T t) {
        t.setCreateDate(new Date());
        ipAddressDao.insert(t);
    }

    @Override
    public void delete() {
        ipAddressDao.delete();
    }

    @Override
    public void deleteByMac(T t) {
        ipAddressDao.deleteByMac(t);
    }
}