package com.test.eurekaClient.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.test.eurekaClient.service.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/test")
@Api(description = "测试用")
public class TestController {
	
	@Autowired
	private TestService testService;

	// 方法说明
	@ApiOperation(value = "value-swagger-获得名字",notes = "notes-swagger-获得名字")
	// 参数
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "姓名", required = false, dataType = "String", paramType = "query"),
		/*@ApiImplicitParam(name = "Accept", value = "接收属性", required = false, dataType = "String", paramType = "header",defaultValue = "application/json"),*/
		@ApiImplicitParam(name = "Accept-Charset", value = "接受字符集", required = false, dataType = "String", paramType = "header",defaultValue = "UTF-8"),
		@ApiImplicitParam(name = "Content-Type", value = "内容类型", required = false, dataType = "String", paramType = "header",defaultValue = "application/json; charset=UTF-8"),
		
	})
	@RequestMapping(value = "/getname", method = RequestMethod.GET/*, produces = "application/json; charset=UTF-8"*/)
	public String getname(HttpServletRequest request,HttpServletResponse response,@RequestParam(value= "name")String name,@RequestHeader(required = false) HttpHeaders headers){
		log.info("swagger2 测试开始"+name+"sessionId"+request.getSession().getId());
		//return "app-Success";
		//return testService.getName(headers, name);
		return testService.getName(name);
		/*try {
			response.sendRedirect("http://localhost:8081/eureka-domain/test/getname?name="+name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";*/
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET/*, produces = "application/json; charset=UTF-8"*/)
	public String test(HttpServletRequest request,HttpServletResponse response,@RequestParam(value= "name")String name,@RequestHeader(required = false) HttpHeaders headers){
		log.info("swagger2 测试开始"+name);
		return "app-Success";
	}
	
	
	@RequestMapping(value = "/dealPostData",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
	public JSONObject dealPostData(HttpServletRequest request,HttpServletResponse response,@RequestBody JSONObject params,@RequestHeader(required = false) HttpHeaders headers){
		log.info("Post方法测试入参"+params);
		params.put("project", "app-Success");
		return params;
	}
	
	@ApiOperation(value = "post方法测试",notes = "post方法测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "params",value = "入参",required = true,dataType = "JSONObject",paramType = "body"),
		@ApiImplicitParam(name = "Accept", value = "接收属性", required = false, dataType = "String", paramType = "header",defaultValue = "application/json"),
		@ApiImplicitParam(name = "Accept-Charset", value = "接受字符集", required = false, dataType = "String", paramType = "header",defaultValue = "UTF-8"),
		@ApiImplicitParam(name = "Content-Type", value = "内容类型", required = false, dataType = "String", paramType = "header",defaultValue = "application/json; charset=UTF-8"),
	})
	@RequestMapping(value = "/dealData",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
	public JSONObject dealData(HttpServletRequest request,HttpServletResponse response,@RequestBody JSONObject params,@RequestHeader(required = false) HttpHeaders headers){
		log.info("Post方法测试入参"+params);
		return params;
	}
	
	
}
