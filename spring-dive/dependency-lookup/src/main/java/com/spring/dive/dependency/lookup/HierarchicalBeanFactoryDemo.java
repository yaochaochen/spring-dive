package com.spring.dive.dependency.lookup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HierarchicalBeanFactoryDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalBeanFactoryDemo.class);
        applicationContext.refresh();
        lookupObjectProvider(applicationContext);
        applicationContext.close();
    }

    private static void lookupObjectProvider(AnnotationConfigApplicationContext applicationContext) {
    }
}
