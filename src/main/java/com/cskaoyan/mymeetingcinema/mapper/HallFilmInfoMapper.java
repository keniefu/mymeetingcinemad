package com.cskaoyan.mymeetingcinema.mapper;

import com.cskaoyan.mymeetingcinema.model.generator.HallFilmInfo;
import com.cskaoyan.mymeetingcinema.model.generator.HallFilmInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HallFilmInfoMapper {
    long countByExample(HallFilmInfoExample example);

    int deleteByExample(HallFilmInfoExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(HallFilmInfo record);

    int insertSelective(HallFilmInfo record);

    List<HallFilmInfo> selectByExample(HallFilmInfoExample example);

    HallFilmInfo selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") HallFilmInfo record, @Param("example") HallFilmInfoExample example);

    int updateByExample(@Param("record") HallFilmInfo record, @Param("example") HallFilmInfoExample example);

    int updateByPrimaryKeySelective(HallFilmInfo record);

    int updateByPrimaryKey(HallFilmInfo record);
}