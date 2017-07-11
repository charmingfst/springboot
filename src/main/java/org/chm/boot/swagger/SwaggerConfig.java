package org.chm.boot.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.reflections.util.ConfigurationBuilder.build;
import static springfox.documentation.builders.PathSelectors.ant;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by charming on 2017/7/6.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //注意WebMvcConfigurerAdapter（MvcConfiguration）中的配置


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo") /*可以定义多个组，比如本类中定义把test和demo区分开了*/
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.chm.boot"))
                .paths(PathSelectors.regex("/demo/.*"))// PathSelectors.any()
                .build();
    }

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("test")
                .apiInfo(apiInfo())
                .genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// 最终调用接口后会和paths拼接在一起
                .select().apis(RequestHandlerSelectors.basePackage("org.chm.boot"))
                .paths(PathSelectors.regex("/test/.*"))//过滤的接口
                .build();
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("test")
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("org.chm.boot"))
//                .paths(PathSelectors.regex("/test/.*"))// PathSelectors.any()
//                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact(new Contact("程序猿DD", "http://blog.csdn.net/zxc123e", "5726633@qq.com"))
                .version("1.0")
                .build();
    }

}
