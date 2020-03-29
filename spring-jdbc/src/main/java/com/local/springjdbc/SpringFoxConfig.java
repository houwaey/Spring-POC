package com.local.springjdbc;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
class SpringFoxConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.local.springjdbc.controller"))	// .apis(RequestHandlerSelectors.any())
					.paths(PathSelectors.any())	//.paths(PathSelectors.ant("/school/***"))
					.build()
				.apiInfo(apiInfo());
	}
	
	@SuppressWarnings("rawtypes")
	private ApiInfo apiInfo() {
	       ApiInfo apiInfo = new ApiInfo(
	      "School RESTful WebService", 
	      "This pages documents School RESTful Web Service endpoints", "1.0",
	      "http://www.houwaey.com/service.html", new Contact("Houwaey Ford", "http://www.houwaey.com", "houwaey@gmail.com"), 
	      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
		return apiInfo;
	}
	
}
