package com.spring.dive.beans;

import com.spring.dive.dependency.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 注解 BeanDefinition
 */
@Import(AnnotationBeanDefinitionDemo.Config.class) //通过 @Import 进行注册 和  @Component 重复定义 Bean 但是不会重复注册
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration (配置类)
        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        applicationContext.refresh();
        Map<String, Config> configMap = applicationContext.getBeansOfType(Config.class);
        System.out.println("Config 所有 所有Beans" + configMap);
        applicationContext.close();
    }

    /**
     * 命名 Bean 注册方式
     * @param registry
     * @param beanName
     * @param beanClass
     */
    public  void registerBeanDefinition(BeanDefinitionRegistry registry, String  beanName, Class<?> beanClass) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1);
        beanDefinitionBuilder.addPropertyValue("name", "spring");

        registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
    }

    @Component //定义当前类作为 Spring Bean(组件)
    public static class Config {

        @Bean(name = {"user", "spring-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("Spring Bean");
            return user;
        }
    }

}
