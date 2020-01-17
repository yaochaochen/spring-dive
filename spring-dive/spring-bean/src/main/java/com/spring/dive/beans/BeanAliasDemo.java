package com.spring.dive.beans;

import com.spring.dive.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名
 */
public class BeanAliasDemo {

    public static void main(String[] args) {

        //启动 spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-definitions-context.xml");


        User user  = beanFactory.getBean("user", User.class);

        //通过别名获取 User 对象
        User aliasUser = beanFactory.getBean("spring-user", User.class);
        System.out.println("User VS AliasUser " + (user == aliasUser));


    }
}
