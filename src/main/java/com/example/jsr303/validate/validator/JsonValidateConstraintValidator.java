package com.example.jsr303.validate.validator;

import com.alibaba.fastjson.JSON;
import com.example.jsr303.validate.annocation.Json;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class JsonValidateConstraintValidator  implements ConstraintValidator<Json,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result = false;
        try {
            Object obj = JSON.parse(value);
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
