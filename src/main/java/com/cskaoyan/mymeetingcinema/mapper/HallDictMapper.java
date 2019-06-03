package com.cskaoyan.mymeetingcinema.mapper;

import com.cskaoyan.mymeetingcinema.model.generator.HallDict;
import com.cskaoyan.mymeetingcinema.model.generator.HallDictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HallDictMapper {
    long countByExample(HallDictExample example);

    int deleteByExample(HallDictExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(HallDict record);

    int insertSelective(HallDict record);

    List<HallDict> selectByExample(HallDictExample example);

    HallDict selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") HallDict record, @Param("example") HallDictExample example);

    int updateByExample(@Param("record") HallDict record, @Param("example") HallDictExample example);

    int updateByPrimaryKeySelective(HallDict record);

    int updateByPrimaryKey(HallDict record);
}