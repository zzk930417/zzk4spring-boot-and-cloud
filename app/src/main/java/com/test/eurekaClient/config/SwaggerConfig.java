package com.test.eurekaClient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2配置类
 * @author Administrator
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	// 默认组配置
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).pathMapping("/").groupName("test")
				.select().apis(RequestHandlerSelectors.basePackage("com.test.eurekaClient.controller")).build()
				.apiInfo(apiInfo());
	}
	
	// swagger页面信息配置
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("个人学习测试系统", // 主标题
        		"个人测试用swagger", // 主标题下的描述
        		"1.0", // 版本
        		"no message", //
        		"应用服务", // 姓名
        		"Apache 2.0", // 链接显示文字
        		"www.apache.org/licenses/LICENSE-2.0"// 链接地址
        		);
        return apiInfo;
    }
}
