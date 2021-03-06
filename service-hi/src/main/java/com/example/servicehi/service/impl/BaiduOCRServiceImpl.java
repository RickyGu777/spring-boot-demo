package com.example.servicehi.service.impl;

import com.example.servicehi.dao.BaiduOCRDao;
import com.example.servicehi.entity.BaiduOCR;
import com.example.servicehi.service.BaiduOCRService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BaiduOCRServiceImpl<T extends BaiduOCR> implements BaiduOCRService<T> {
    @Autowired
    private BaiduOCRDao<T> baiduOCRDao;

    @Override
    public void insert(T t) {
        t.setIsDel("0");
        t.setCreateDate(new Date());
        t.setModiDate(t.getCreateDate());
        baiduOCRDao.insert(t);
    }

    @Override
    public T selectByUUID(T t) {
        return baiduOCRDao.selectByUUID(t);
    }

    @Override
    public PageInfo selectOCRList(T t) {
        PageHelper.offsetPage(t.getPage(), t.getSize());
        return new PageInfo<>(baiduOCRDao.selectOCRList(t));
    }

    @Override
    public void delete(T t) {
        t.setModiDate(new Date());
        baiduOCRDao.delete(t);
    }
}
