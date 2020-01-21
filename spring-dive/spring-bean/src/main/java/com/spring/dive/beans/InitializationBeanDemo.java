package com.spring.dive.beans;

import com.spring.dive.beans.factory.DefaultUserFactory;
import com.spring.dive.beans.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializationBeanDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.refresh();
        applicationContext.register(InitializationBeanDemo.class);
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        applicationContext.close();
    }

    @Bean
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }

}
