package org.chm.boot.servlet;

import org.chm.boot.mq.HelloSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by charming on 2017/7/6.
 */
@WebListener
public class IndexListener implements ServletContextListener {
    protected static Logger logger = LoggerFactory.getLogger(HelloSender.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获取web.xml中配置的属性
        String value=servletContextEvent.getServletContext().getInitParameter("spring.datasource.url");
        logger.info("IndexListener contextInitialized "+value);
    }



    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
