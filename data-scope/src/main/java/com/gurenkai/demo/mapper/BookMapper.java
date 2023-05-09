package com.gurenkai.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gurenkai.demo.persistence.BookDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper extends BaseMapper<BookDo> {

    List<BookDo> aliasTestSelect();

}
