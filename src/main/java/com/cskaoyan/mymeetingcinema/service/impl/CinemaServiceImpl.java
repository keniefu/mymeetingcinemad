package com.cskaoyan.mymeetingcinema.service.impl;

import com.cskaoyan.mymeetingcinema.mapper.*;
import com.cskaoyan.mymeetingcinema.model.generator.*;
import com.cskaoyan.mymeetingcinema.model.outputparam.*;
import com.cskaoyan.mymeetingcinema.model.result.ExceptionResult;
import com.cskaoyan.mymeetingcinema.model.inputparam.CinemaQueryVO;
import com.cskaoyan.mymeetingcinema.model.result.GetCinemasResult;
import com.cskaoyan.mymeetingcinema.model.result.GetConditionResult;
import com.cskaoyan.mymeetingcinema.model.result.Result;
import com.cskaoyan.mymeetingcinema.service.CinemaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    CinemaMapper cinemaMapper;
    @Autowired
    BrandDictMapper brandDictMapper;
    @Autowired
    AreaDictMapper areaDictMapper;
    @Autowired
    HallDictMapper hallDictMapper;
    @Autowired
    FieldMapper fieldMapper;

    @Override
    public Result getCinemas(CinemaQueryVO cinemaQueryVO) {
        PageHelper.startPage(cinemaQueryVO.getNowPage(), cinemaQueryVO.getPageSize());
        CinemaExample cinemaExample = new CinemaExample();
        CinemaExample.Criteria criteria = cinemaExample.createCriteria();
        if (cinemaQueryVO.getBrandId() != 99) {
            criteria.andBrandIdEqualTo(cinemaQueryVO.getBrandId());
        }
        if (cinemaQueryVO.getDistrictId() != 99) {
            criteria.andAreaIdEqualTo(cinemaQueryVO.getDistrictId());
        }
        if (cinemaQueryVO.getHallType() != 99) {
            criteria.andHallIdsLike("%" + cinemaQueryVO.getHallType() + "#%");
        }
        List<Cinema> cinemas = null;
        List<CinemaVO> list = new ArrayList<>();
        GetCinemasResult cinemasResult = null;
        try {
            cinemas = cinemaMapper.selectByExample(cinemaExample);
            for (Cinema cinema : cinemas) {
                CinemaVO cinemaVO = new CinemaVO(cinema.getUuid(), cinema.getCinemaName(), cinema.getCinemaAddress(), Double.parseDouble(cinema.getMinimumPrice().toString()));
                list.add(cinemaVO);
            }
            PageInfo<CinemaVO> pageInfo = new PageInfo<>(list);
            cinemasResult = new GetCinemasResult(200, pageInfo.getPageNum(), pageInfo.getPageSize(), list);
        } catch (Exception e) {
            return new ExceptionResult(1, "影院信息查询失败");
        }
        return cinemasResult;
    }

    @Override
    public Result getCondition(Integer brandId, Integer hallType, Integer areaId) {
        BrandDictExample brandDictExample = new BrandDictExample();
        HallDictExample hallDictExample = new HallDictExample();
        AreaDictExample areaDictExample = new AreaDictExample();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        String time = simpleDateFormat.format(date);
        ConditionVO conditionVO = null;
        GetConditionResult getConditionResult = null;
        if (brandId != null && brandId != 99) {
            brandDictExample.createCriteria().andUuidEqualTo(brandId);
        }
        if (hallType != null && hallType != 99) {
            hallDictExample.createCriteria().andUuidEqualTo(hallType);
        }
        if (areaId != null && areaId != 99) {
            areaDictExample.createCriteria().andUuidEqualTo(areaId);
        }
        try {
            List<BrandDict> brandDicts = brandDictMapper.selectByExample(brandDictExample);
            List<MyBrand> brands = new ArrayList<>();
            for (BrandDict brandDict : brandDicts) {
                MyBrand myBrand = new MyBrand(brandDict.getUuid(), brandDict.getShowName(), true);
                FieldExample fieldExample = new FieldExample();
                fieldExample.createCriteria().andCinemaIdEqualTo(brandDict.getUuid()).andBeginTimeLessThan(time).andEndTimeGreaterThan(time);
                List<Field> fields = fieldMapper.selectByExample(fieldExample);
                if (fields == null || fields.size() == 0) {
                    myBrand.setActive(false);
                }
                brands.add(myBrand);
            }
            List<HallDict> hallDicts = hallDictMapper.selectByExample(hallDictExample);
            ArrayList<MyHalltype> halltypes = new ArrayList<>();
            for (HallDict hallDict : hallDicts) {
                MyHalltype myHalltype = new MyHalltype(hallDict.getUuid(), hallDict.getShowName(), true);
                FieldExample fieldExample = new FieldExample();
                fieldExample.createCriteria().andHallIdEqualTo(hallDict.getUuid()).andBeginTimeLessThan(time).andEndTimeGreaterThan(time);
                List<Field> fields = fieldMapper.selectByExample(fieldExample);
                if (fields == null || fields.size() == 0) {
                    myHalltype.setActive(false);
                }
                halltypes.add(myHalltype);
            }
            List<AreaDict> areaDicts = areaDictMapper.selectByExample(areaDictExample);
            ArrayList<MyArea> myAreas = new ArrayList<>();
            for (AreaDict areaDict : areaDicts) {
                MyArea myArea = new MyArea(areaDict.getUuid(), areaDict.getShowName(), true);
                myAreas.add(myArea);
            }
            conditionVO = new ConditionVO(brands, myAreas, halltypes);
            getConditionResult = new GetConditionResult(200, conditionVO);
        } catch (Exception e) {
            return new ExceptionResult(1, "影院信息查询失败");
        }
        return getConditionResult;
    }
}
