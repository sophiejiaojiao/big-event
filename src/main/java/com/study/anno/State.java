package com.study.anno;
/*自定义注解*/


import com.study.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented // 元注解，表示该注解可放到帮助文档中
@Target({ElementType.FIELD}) // 元注解，该注解用在什么地方
@Retention(RetentionPolicy.RUNTIME) // 元注解，什么时候用
@Constraint(validatedBy = {StateValidation.class}) // 指定提供校验规则的类（自定义的）
public @interface State {
    // 提供校验失败后的提示信息
    String message() default "state参数的值只能是已发布或者草稿";
    // 指定分组
    Class<?>[] groups() default {};
    // 负载，获取state注解的附加信息，暂时不关注，一般用不着
    Class<? extends Payload>[] payload() default {};
}
