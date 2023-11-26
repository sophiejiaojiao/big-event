package com.study.validation;

import com.study.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// ConstraintValidator的参数：给哪个注解提供校验规则，校验的数据类型
public class StateValidation implements ConstraintValidator<State, String> {
    /**
     * @param value   将来要校验的数据
     * @param context
     * @return false校验不通过，true校验通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        /*提供校验规则*/
        if (value == null) {
            return false;
        }
        if (value.equals("已发布") || value.equals("草稿")) {
            return true;
        }
        return false;
    }
}
