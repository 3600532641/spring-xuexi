package com.baiwang.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 描述
 *
 * @author
 */
public class MyImportSelector implements ImportSelector {
    //AnnotationMetadata 当前类的注解信息
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.baiwang.bean.Bule"};
    }
}