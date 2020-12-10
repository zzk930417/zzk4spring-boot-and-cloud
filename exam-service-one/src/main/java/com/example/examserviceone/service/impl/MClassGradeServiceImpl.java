package com.example.examserviceone.service.impl;

import com.example.examserviceone.service.MClassGradeService;
import com.example.examserviceone.vo.mclassgrade.MClassGrade;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MClassGradeServiceImpl
 * @Author: lingduyelang
 * @Date: 2020-11-23 10:30
 **/
@Service("mClassGradeServiceImpl")
public class MClassGradeServiceImpl implements MClassGradeService {



    @Override
    public MClassGrade getMClassGradeById(Integer id) {
        MClassGrade mClassGrade = new MClassGrade();
        mClassGrade.setId(1);
        return mClassGrade;
    }


}
