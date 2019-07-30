package com.baiwang.config;

import com.baiwang.bean.Person;
import com.baiwang.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * 描述
 *
 * @author
 */
@Configuration//相当于之前beans.xml
@ComponentScans(value = {
        @ComponentScan(value = "com.baiwang", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        }, useDefaultFilters = false)
})
//@ComponentScans 包含多个ComponentScan
//过滤规则 includeFilters =Filter[] 指定那些，禁用默认规则不用禁用的话 不生效
//过滤规则 excludeFilters =Filter[] 排除那些注解类型排除
//FilterType.ANNOTATION 按照注解过滤
// FilterType.ASSIGNABLE_TYPE 安装指定类型
//FilterType.ASPECTJ 按照ASPECTJ匹配
//FilterType.REGEX 按照正则匹配
//FilterType.CUSTOM自定义匹配
public class MainConfig {

    @Bean(name = "person012")
    public Person person01() {//默认是方法名作为bean的id
        return new Person("lisi", 20);
    }
}