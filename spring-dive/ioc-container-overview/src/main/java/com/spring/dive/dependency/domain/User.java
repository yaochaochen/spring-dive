package com.spring.dive.dependency.domain;

import com.spring.dive.dependency.enums.City;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.util.Arrays;
import java.util.List;

public class User {

    private Long id;

    private String name;

    private City[] city;

    private List<City> lifeCites;

    private Resource configFileLocation;

    /**
     * 当前 Bean 的名称
     */
    private transient String beanName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City[] getCity() {
        return city;
    }

    public void setCity(City[] city) {
        this.city = city;
    }

    public List<City> getLifeCites() {
        return lifeCites;
    }

    public void setLifeCites(List<City> lifeCites) {
        this.lifeCites = lifeCites;
    }

    public Resource getConfigFileLocation() {
        return configFileLocation;
    }

    public void setConfigFileLocation(Resource configFileLocation) {
        this.configFileLocation = configFileLocation;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + Arrays.toString(city) +
                ", lifeCites=" + lifeCites +
                ", configFileLocation=" + configFileLocation +
                ", beanName='" + beanName + '\'' +
                '}';
    }
    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("姚超臣");
        return user;
    }

    @PostConstruct
    public void init() {
        System.out.println("User Bean [" + beanName + "] 初始化...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("User Bean [" + beanName + "] 销毁中...");
    }

}
