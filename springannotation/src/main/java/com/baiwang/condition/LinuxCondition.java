package com.baiwang.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 描述
 *
 * @author
 */
public class LinuxCondition  implements Condition

{
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String linux = environment.getProperty("os.name");
        if(linux.contains("Linux")){
            return true;
        }
        return false;
    }
}