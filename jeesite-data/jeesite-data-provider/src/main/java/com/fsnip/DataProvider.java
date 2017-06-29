package com.fsnip;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.container.Container;
import com.fsnip.date.DateUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataProvider implements Serializable{
	public static final String CONTAINER_KEY = "dubbo.container";
    public static final String SHUTDOWN_HOOK_KEY = "dubbo.shutdown.hook";
    public static final String APP_NAME = "cloud-data-provider";
    private static final Logger logger = LoggerFactory.getLogger(DataProvider.class);
    private static final ExtensionLoader<Container> loader = ExtensionLoader.getExtensionLoader(Container.class);
    private static volatile boolean running = true;
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
        	context.start();
        	logger.info("==DataProvider==Dubbo " + APP_NAME + "!服务启动成功！"+ DateUtil.dateToString(new Date()));
            System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " Dubbo " + APP_NAME + " started!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            logger.error("==DataProvider==服务启动异常："+ DateUtil.dateToString(new Date())+e.getMessage(), e);
            System.exit(1);
        }
        synchronized (DataProvider.class) {
            while (running) {
                try {
                    logger.info("==DataProvider==服务启动成功！"+ DateUtil.dateToString(new Date()));
                	DataProvider.class.wait();
                } catch (Throwable e) {
                    logger.info("==DataProvider==服务启动报错！"+ DateUtil.dateToString(new Date()));
                }
            }
        }
    }
}
