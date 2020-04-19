package com.ssm.pojo;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

//对象要可序列化,需要实现Serializable,并且重写serialVersionUID
@Alias("role")
@Component("role")
public class Role
        implements
        Serializable
        , BeanNameAware
        , BeanFactoryAware
        , ApplicationContextAware
        , InitializingBean
//        ,BeanFactoryPostProcessor
{


    //    序列化的版本编号
    private static final long serialVersionUID = 6977402643848374753L;

    @Value("20190116164752")
    private String id;
    @Value("2019年1月16日16:47:58的测试数据")
    private String rolename;
    @Value("要相信，一定会康复的，一切都会康复的！！")
    private String note;
    private Date cjsj;

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", rolename='" + rolename + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public Role() {
    }

    public Role(String id, String rolename, String note) {
        this.id = id;
        this.rolename = rolename;
        this.note = note;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public void setBeanName(String arg0) {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanNameAware接口的setBeanName方法");

    }

    //自定义初始化方法
    public void init() {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义初始化方法");
    }

    //自定义销毁方法
    public void destroy() {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义销毁方法");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanFactoryAware接口的setBeanFactory方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用InitializingBean接口的afterPropertiesSet方法");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用ApplicationContextAware接口的setApplicationContext方法");
    }

//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanFactoryPostProcessor接口的postProcessBeanFactory方法");
//    }


    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }
}
