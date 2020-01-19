package com.spring.dive.beans;

import com.spring.dive.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiation {

    public static void main(String[] args) {

        //启动 spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation-context.xml");

        User user = beanFactory.getBean("user-by-static-method", User.class);
        System.out.println("user-by-static-method" + user);

        User userFactory = beanFactory.getBean("user-by-instance-method", User.class);
        System.out.println("user-by-instance-method ：" + userFactory);

        System.out.println("user-by-instance-method VS user-by-static-method : " + (user == userFactory));
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);

        System.out.println("user-by-factory-bean : " + userByFactoryBean);
    }
}
