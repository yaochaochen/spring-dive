package com.spring.dive.beans.factory;

import javax.annotation.PostConstruct;

public class DefaultUserFactory implements UserFactory {


    @PostConstruct
    public void  init(){
        System.out.println("PostConstruct : 初始化中..." );
    }

    public  void  UserFactoryInit() {
        System.out.println("PostConstruct : 初始化中..." );
    }
}
