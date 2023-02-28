package com.example.jsr303.validate.validator;

import com.example.jsr303.validate.annocation.ListVale;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class ListValueValidateConstraintValidator implements ConstraintValidator<ListVale,String> {

   private Set<String> set =new HashSet<>();
    @Override
    public void initialize(ListVale constraintAnnotation) {
        String[] vals = constraintAnnotation.vals();
        for (String val : vals) {
            set.add(val);
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
