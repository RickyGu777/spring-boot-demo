package com.example.servicehi.controller;

import com.example.servicehi.entity.dto.DiaryDto;
import com.example.servicehi.service.DiaryService;
import com.example.servicehi.util.IPAddressUtil;
import com.example.servicehi.util.ResponseUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/Diary")
@RestController
@AllArgsConstructor
@Slf4j
public class DiaryController<T extends DiaryDto> {
    private final DiaryService diaryService;

    @PostMapping(value = "/addDiary")
    public ResponseUtil addDiary(@RequestBody T t) {
        diaryService.insert(t);
        return new ResponseUtil();
    }

    @PostMapping(value = "/selectDiaryList")
    public ResponseUtil selectDiaryList(@RequestBody T t) {
        return new ResponseUtil<>(diaryService.selectDiaryList(t));
    }

    @PostMapping(value = "/selectByUUID")
    public ResponseUtil selectByUUID(@RequestBody T t) {
        return new ResponseUtil<>(diaryService.selectByUUID(t));
    }

    @PostMapping(value = "/updateDiaryByUUID")
    public ResponseUtil updateDiaryByUUID(@RequestBody T t) {
        diaryService.updateDiaryByUUID(t);
        return new ResponseUtil<>();
    }

    @PostMapping(value = "/deleteDiaryByUUID")
    public ResponseUtil deleteDiaryByUUID(@RequestBody T t) {
        diaryService.deleteDiaryByUUID(t);
        return new ResponseUtil<>();
    }
}