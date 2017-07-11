package org.chm.boot.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by charming on 2017/7/6.
 */
@RestController
@RequestMapping("/demo")
@Api(value = "订单类",tags = "订单类测试接口")
public class DemoController {
    @RequestMapping(value = "/demo2.do", method = RequestMethod.GET)
    @ApiOperation(value = "获取helloWorld", notes = "简单SpringMVC请求")
    String getDemo() {
        return "Hello World \n" + "Spring boot3";
    }
}
