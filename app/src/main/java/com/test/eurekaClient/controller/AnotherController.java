package com.test.eurekaClient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/another")
public class AnotherController {

	
	/**
	 * 重定向大批量数据处理
	 * @param params
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/redirectDate",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
	public ModelAndView redirectDate(HttpServletRequest request ,@RequestBody JSONObject params){
		log.info("redirectDate方法测试入参"+params);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:http://localhost:8081/eureka-domain/another/redirectDate");
		//redirectAttributes.addFlashAttribute("params", params.toString());
		mv.addObject("params", params.toString());
		return mv;
	} 
	
	
}
