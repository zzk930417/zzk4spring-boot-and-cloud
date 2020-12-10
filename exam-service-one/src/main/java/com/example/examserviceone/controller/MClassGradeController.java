package com.example.examserviceone.controller;

import com.example.examserviceone.service.MClassGradeService;
import com.example.examserviceone.vo.mclassgrade.MClassGrade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: MClassGradeController
 * @Author: lingduyelang
 * @Date: 2020-11-30 11:14
 **/
@RestController
@RequestMapping("/mclassgrade")
@Slf4j
public class MClassGradeController {

    @Autowired
    private MClassGradeService mClassGradeService;

    @GetMapping(value = "/getById")
    public MClassGrade getMclassGradeById(HttpServletRequest request, HttpServletResponse response, Integer id){
        log.info("根据id获取班级信息（one）"+id);
        return mClassGradeService.getMClassGradeById(id);
    }
}
