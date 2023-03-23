package com.gurenkai.demo.infrastructure.config.mp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @author gu_renkai
 * @date 2022/12/6 10:58
 */

public interface EasyBaseMapper<T> extends BaseMapper<T> {

    int recoverByPk(@Param("ids") List<? extends Serializable> ids);

    int recover(@Param(Constants.WRAPPER) Wrapper<T> ew);

    int physicalDeleteByPk(@Param("ids") List<? extends Serializable> ids);

}