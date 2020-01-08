package com.spring.dive.dependency.injection;

import com.spring.dive.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入
 */
public class DependencyInjectionDemo {


    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        //依赖来源-:自定义 Bean
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository.getUsers());

        //依赖来源二 依赖注入 内建依赖
        System.out.println(userRepository.getObjectFactory());

        //容器内建  Bean
        Environment environment =  beanFactory.getBean(Environment.class);
        System.out.println(environment.toString());


    }
}
