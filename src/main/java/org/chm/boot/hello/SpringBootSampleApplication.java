package org.chm.boot.hello;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by charming on 2017/7/1.
 */
//项目部署到外部容器时需要的启动类
public class SpringBootSampleApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //指定启动入口类
        return builder.sources(SampleController.class);
    }
}
