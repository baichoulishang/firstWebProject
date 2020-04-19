package com.ssm.objectFactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;

public class MyObjectFactory extends DefaultObjectFactory {
    private static final long serialVersionUID = -8855120656740914948L;
    //日常日志
    Logger logger = Logger.getLogger(MyObjectFactory.class);

    private Object temp = null;

    //调用父方法创造对象
    //主要方法还是父方法

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {

        T result = super.create(type, constructorArgTypes, constructorArgs);
        logger.info("第一次创建对象的方法" + result.toString());
        temp = result;
        return result;
    }

    @Override
    public <T> T create(Class<T> type) {
        T result = super.create(type);
        logger.info("第二次创建对象的方法" + result.toString());
        logger.info("是否和之前的对象一样" + temp==result);
        return result;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        logger.info("初始化的参数"+properties.toString());
    }



    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
