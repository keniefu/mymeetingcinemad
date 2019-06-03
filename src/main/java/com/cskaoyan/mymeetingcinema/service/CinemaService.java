package com.cskaoyan.mymeetingcinema.service;

import com.cskaoyan.mymeetingcinema.model.inputparam.CinemaQueryVO;
import com.cskaoyan.mymeetingcinema.model.result.Result;

public interface CinemaService  {
    Result getCinemas(CinemaQueryVO cinemaQueryVO);

    Result getCondition(Integer brandId, Integer hallType, Integer areaId);
}
