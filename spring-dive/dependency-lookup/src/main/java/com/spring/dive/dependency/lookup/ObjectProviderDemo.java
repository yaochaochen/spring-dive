package com.spring.dive.dependency.lookup;

import com.spring.dive.dependency.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ObjectProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();
        lookupObjectProvider(applicationContext);
        lookupAvailable(applicationContext);

        applicationContext.close();

    }

    private static void lookupAvailable(AnnotationConfigApplicationContext applicationContext) {

        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        User user = userObjectProvider.getIfAvailable(() -> User.createUser());
        System.out.println("当前 User 对象 : " + user);

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
