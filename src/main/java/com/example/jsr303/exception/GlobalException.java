package com.example.jsr303.exception;

import com.example.jsr303.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackages = "com.example.jsr303.controller")
@Slf4j
public class GlobalException {

    @ExceptionHandler
    public R handValidateException(MethodArgumentNotValidException e){
        Map<String,String> map = new HashMap<>();
        log.error("数据校验出先问题{}:,异常类型:{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getFieldErrors().forEach(item->{
            map.put(item.getField(),item.getDefaultMessage());
        });
        return R.error(map);
   }

   @ExceptionHandler
    public R handleException(Throwable throwable){
        return R.error();
    }

}
