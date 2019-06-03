package com.cskaoyan.mymeetingcinema.mapper;

import com.cskaoyan.mymeetingcinema.model.generator.BrandDict;
import com.cskaoyan.mymeetingcinema.model.generator.BrandDictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandDictMapper {
    long countByExample(BrandDictExample example);

    int deleteByExample(BrandDictExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(BrandDict record);

    int insertSelective(BrandDict record);

    List<BrandDict> selectByExample(BrandDictExample example);

    BrandDict selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") BrandDict record, @Param("example") BrandDictExample example);

    int updateByExample(@Param("record") BrandDict record, @Param("example") BrandDictExample example);

    int updateByPrimaryKeySelective(BrandDict record);

    int updateByPrimaryKey(BrandDict record);
}