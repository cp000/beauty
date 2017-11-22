package com.meixiang.beauty.sys.interceptor;

import java.lang.annotation.*;


/**
 * service
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    String description() default "";
}
