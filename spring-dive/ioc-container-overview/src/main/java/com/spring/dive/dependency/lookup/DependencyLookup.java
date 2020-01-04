package com.spring.dive.dependency.lookup;

import com.spring.dive.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖查找实例
 */
public class DependencyLookup {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        lookupRealTime(beanFactory);
    }

    private static void lookupRealTime(BeanFactory beanFactory) {
        User user =  (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }
}
