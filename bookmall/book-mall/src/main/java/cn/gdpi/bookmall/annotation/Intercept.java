package cn.gdpi.bookmall.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 16:46
 ***/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Intercept {

    int role() default 0;
}
