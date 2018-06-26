package com.zyouke.listener;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: zhoujun
 * 监听器,加载日志
 */
public class LogListener implements ServletContextListener {
    private static Logger LOGGER = LoggerFactory.getLogger(LogListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        try {
            configurator.doConfigure("F:/zyouke_git/solrSource/web/src/main/resources/logback.xml");
        } catch (JoranException e) {
            e.printStackTrace();
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
        LOGGER.info("-----------------:加载日志配置文件完成!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("-----------------:jetty 关闭");
    }
}
