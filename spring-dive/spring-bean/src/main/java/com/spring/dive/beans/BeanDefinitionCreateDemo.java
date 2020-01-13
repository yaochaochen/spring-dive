package com.spring.dive.beans;

import com.spring.dive.dependency.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Map;

/**
 * BeanDefinition 实例
 */
public class BeanDefinitionCreateDemo {

    public static void main(String[] args) {
        /// 1.通过 builder 方式
        BeanDefinitionBuilder builder =  BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //设置属性
        builder.addPropertyValue("age", 43);
        builder.addPropertyValue("name", "Spring-Dive");
        //获取实例
        BeanDefinition definition = builder.getBeanDefinition();

        //BeanDefinition 并非 Bean 的终态 可以自定义修改
        // 2. AbstractBeanDefinition 实现
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("age", 1);
        mutablePropertyValues.addPropertyValue("name", "Spring");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);

    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有的 User 集合对象" + users);
        }
    }
}
