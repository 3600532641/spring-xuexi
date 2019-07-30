package com.baiwang.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 描述 自定义匹配规则
 *
 * @author
 */

public class MyTypeFilter implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //当前类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //资源信息
        Resource resource = metadataReader.getResource();
        System.out.println("------->" + classMetadata.getClassName());
        String className = classMetadata.getClassName();
        if(className.contains("er")){return true;}
        return false;
    }
}