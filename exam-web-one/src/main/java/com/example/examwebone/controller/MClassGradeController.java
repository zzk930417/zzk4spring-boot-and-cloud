package com.example.examwebone.controller;

import com.example.examwebone.vo.mclassgrade.MClassGrade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: MClassGradeController
 * @Author: lingduyelang
 * @Date: 2020-11-30 11:14
 **/
@RestController
@RequestMapping("/mclassgrade")
public class MClassGradeController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET,value = "/getById")
    public MClassGrade getMclassGradeById(HttpServletRequest request, HttpServletResponse response,Integer id){
        String url = "http://SERVICE/mclassgrade/getById?id=" +id;
        //return restTemplate.getForObject("http://localhost:8081/mclassgrade/getById?id=1", MClassGrade.class);
        return restTemplate.getForObject(url, MClassGrade.class);
    }


}
