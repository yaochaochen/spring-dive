package com.spring.dive.dependency.container;

import com.spring.dive.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * IOC
 */
public class BeanFactoryAsIoCContainerDemo {

    public static void main(String[] args) {
        //创建 beanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //classpath:/META-INF/dependency-injection-context.xml
        String classPath = "classpath:/META-INF/dependency-injection-context.xml";
        //加载资源
        int beanCount =  reader.loadBeanDefinitions(classPath);
        System.out.println(" Bean 的个数 " + beanCount);
        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有的 User 集合对象" + users);
        }
    }
}
