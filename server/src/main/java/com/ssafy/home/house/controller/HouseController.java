package com.ssafy.home.house.controller;

import com.ssafy.home.common.dto.ResponseDTO;
import com.ssafy.home.house.dto.DealInfoDTO;
import com.ssafy.home.house.dto.HouseDTO;
import com.ssafy.home.house.service.HouseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@Api(tags = {"house"})
@RestController
@RequestMapping("house")
@RequiredArgsConstructor
public class HouseController {
    private final HouseService houseService;


    @PostMapping("dealinfo")
    public ResponseEntity<ResponseDTO> getHouseDealInfo(
            @RequestBody DealInfoDTO dealInfoDTO) {
        List<HouseDTO> list = houseService.getHouseDealInfo(dealInfoDTO);
        ResponseDTO res = new ResponseDTO();
        res.setStatus("success");
        res.setBody(list);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("dong")
    public ResponseEntity<ResponseDTO> getDong(
            @RequestBody Map<String, String> map) {
        String sidoName = map.get("sidoName").trim();
        String gugunName = map.get("gugunName").trim();

        List<String> dongs = houseService.getDong(sidoName, gugunName);
        ResponseDTO res = new ResponseDTO();
        res.setBody(dongs);
        res.setStatus("success");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    
    @PostMapping("gugun")
    public ResponseEntity<ResponseDTO> getGugun(
            @RequestBody Map<String, String> map) {
        String sidoName = map.get("sidoName").trim();
        List<String> guguns = houseService.gugun(sidoName);
        ResponseDTO res = new ResponseDTO();
        res.setBody(guguns);
        res.setStatus("success");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
