package org.chm.boot.servlet;

import org.chm.boot.mq.HelloSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by charming on 2017/7/6.
 */
@WebFilter(urlPatterns = "/*", filterName = "indexFilter")
public class IndexFilter implements Filter {
    protected static Logger logger = LoggerFactory.getLogger(HelloSender.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init IndexFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter IndexFilter before");
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("doFilter IndexFilter after");
    }

    @Override
    public void destroy() {

    }
}

