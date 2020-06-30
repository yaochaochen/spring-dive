package com.spring.dive.bean.scope;

import com.spring.dive.dependency.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @description:
 * @author: yaochaochen
 * @since: 2020/6/30
 */
public class BeanScopeDemo {

    @Bean
    public static User singletonUser() {
        return createUser();
    }


    @Bean(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser() {
        return createUser();
    }

    public static User createUser() {
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }

    public static void main(String[] args) {
        //创建 Bean 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册
        context.register(BeanScopeDemo.class);

        context.addBeanFactoryPostProcessor( beanFactory -> {
            beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
                @Override
                public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                    System.out.printf("%s Bean 名称:%s 在初始化后回调...%n", bean.getClass().getName(), beanName);
                    return bean;
                }
            });
        });
        context.refresh();
    }
    // 结论一：
    // Singleton Bean 无论依赖查找还是依赖注入，均为同一个对象
    // Prototype Bean 无论依赖查找还是依赖注入，均为新生成的对象

    // 结论二：
    // 如果依赖注入集合类型的对象，Singleton Bean 和 Prototype Bean 均会存在一个
    // Prototype Bean 有别于其他地方的依赖注入 Prototype Bean

    // 结论三：
    // 无论是 Singleton 还是 Prototype Bean 均会执行初始化方法回调
    // 不过仅 Singleton Bean 会执行销毁方法回调
}
