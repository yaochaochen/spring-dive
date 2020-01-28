package com.spring.dive.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ObjectProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();
        lookupObjectProvider(applicationContext);
        applicationContext.close();

    }

    @Bean
    public String helloWorld() {
        return "hello World";
    }
    private static void lookupObjectProvider(AnnotationConfigApplicationContext applicationContext) {

        ObjectProvider<String> provider = applicationContext.getBeanProvider(String.class);
        System.out.println(provider.getObject());

    }
}
