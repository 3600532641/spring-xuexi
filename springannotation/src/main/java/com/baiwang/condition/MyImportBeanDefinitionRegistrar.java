package com.baiwang.condition;

import com.baiwang.bean.Yello;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 描述
 *
 * @author
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    //BeanDefinitionRegistry bean注册类
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean b = registry.containsBeanDefinition("person");
        if (b) {

            registry.registerBeanDefinition("yello", new RootBeanDefinition(Yello.class));
        }
    }
}