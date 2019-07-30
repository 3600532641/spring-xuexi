package com.baiwang.config;

import com.baiwang.bean.Color;
import com.baiwang.bean.Person;
import com.baiwang.bean.Red;
import com.baiwang.condition.MyImportBeanDefinitionRegistrar;
import com.baiwang.condition.MyImportSelector;
import com.baiwang.condition.WinCondition;
import org.springframework.context.annotation.*;

/**
 * 描述
 *
 * @author
 */
//Conditional 放在类上只要 生效 配置才能生效
@Conditional(value = {WinCondition.class})
@Configuration
/**
 * @Import 导入ioc容器
 * ImportSelector
 * ImportBeanDefinitionRegistrar
 */
@Import(value = {Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {


    /**
     * 作用域
     * * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE prototype
     * * @see ConfigurableBeanFactory#SCOPE_SINGLETON singleton
     * * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request
     * * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session
     * <p>
     * prototype 多实例，获取的时候创建
     * singleton 单实例默认，ioc创建的时候创建 需要的时候直接从容器中拿map.get()
     * request 同一个请求创建
     * session 统一个session
     * <p>
     * 懒加载
     * 单实例bean，默认容器启动的时候创建
     * 懒加载 容器启动的时候不创建，第一次使用的时候创建对象 并初始化
     *
     * @return
     */
    //@Scope("prototype")
    @Lazy
    @Bean(value = "person")
    public Person person() {
        System.out.println("向IOC容器添加person。。。。。。。");
        return new Person("lise", 20);
    }


    @Bean(value = "win")
    public Person person01() {
        return new Person("win", 63);
    }

    @Bean(value = "liunx")
    public Person person02() {
        return new Person("liunx", 48);
    }
}