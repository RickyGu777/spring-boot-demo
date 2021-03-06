package com.example.servicehi.dao;

import com.example.servicehi.entity.UploadImg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UploadImgDao<T extends UploadImg> {
    void insert(T t);

    List<T> selectImageInfoByOriginalName(T t);

    T selectImageInfoByRandomName(T t);

    T selectByUUID(T t);

    void updateTitle(T t);

    List<T> selectPictureWall(T t);

    T selectByTitle(T t);
}