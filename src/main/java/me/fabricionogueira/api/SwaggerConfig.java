package me.fabricionogueira.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("me.fabricionogueira.api"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo())
			.useDefaultResponseMessages(false)
			.globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder()
					.code(500)
					.message("500 some error ")
					.responseModel(new ModelRef("Error"))
					.build(),
				new ResponseMessageBuilder()
					.code(403)
					.message("Forbidden! ;* ")
					.build()));

	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
			"Minha API",
			"Some custom description of API.",
			"v1",
			"Terms of service",
			new Contact(
				"Fabricio Nogueira",
				"https://fabricionogueira.me",
				"nogsantos@gmail.com"
			),
			"License", "MIT", Collections.emptyList());
	}

}
