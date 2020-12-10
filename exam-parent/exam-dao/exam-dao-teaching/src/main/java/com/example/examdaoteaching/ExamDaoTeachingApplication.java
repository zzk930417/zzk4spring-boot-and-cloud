package com.example.examdaoteaching;

import com.example.teach.entity.MClassGrade;
import com.example.teach.mapper.MClassGradeMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@MapperScan("com.example.*.mapper") // dao文件扫描
@RestController
@Slf4j
public class ExamDaoTeachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamDaoTeachingApplication.class, args);
    }

    @Autowired
    private MClassGradeMapper mClassGradeMapper;

    @RequestMapping("/")
    public String hello(HttpServletRequest request, HttpServletResponse response,Integer id){
        MClassGrade mClassGrade = mClassGradeMapper.selectByPrimaryKey(id);
        log.info("本次查到的数据条数：{}",mClassGrade.toString());
        return "hello";
    }

}
