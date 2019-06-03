package com.cskaoyan.mymeetingcinema.controller;

import com.cskaoyan.mymeetingcinema.model.inputparam.CinemaQueryVO;
import com.cskaoyan.mymeetingcinema.model.result.ExceptionResult;
import com.cskaoyan.mymeetingcinema.model.result.Result;
import com.cskaoyan.mymeetingcinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CinemaController {
    @Autowired
    CinemaService cinemaService;

    @GetMapping("/cinema/getCinemas")
    @ResponseBody
    public Result getCinemas(CinemaQueryVO cinemaQueryVO) {
        Result cinemasResult = cinemaService.getCinemas(cinemaQueryVO);
        return cinemasResult;
    }


    @GetMapping("/cinema/getCondition")
    @ResponseBody
    public Result getCondition(Integer brandId,Integer hallType,Integer areaId) {
        Result cinemasResult = cinemaService.getCondition(brandId,hallType,areaId);
        return cinemasResult;
    }
}
