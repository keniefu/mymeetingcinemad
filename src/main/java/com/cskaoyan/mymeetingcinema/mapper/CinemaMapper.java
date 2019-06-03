package com.cskaoyan.mymeetingcinema.mapper;

import com.cskaoyan.mymeetingcinema.model.generator.Cinema;
import com.cskaoyan.mymeetingcinema.model.generator.CinemaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CinemaMapper {
    long countByExample(CinemaExample example);

    int deleteByExample(CinemaExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(Cinema record);

    int insertSelective(Cinema record);

    List<Cinema> selectByExample(CinemaExample example);

    Cinema selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") Cinema record, @Param("example") CinemaExample example);

    int updateByExample(@Param("record") Cinema record, @Param("example") CinemaExample example);

    int updateByPrimaryKeySelective(Cinema record);

    int updateByPrimaryKey(Cinema record);
}