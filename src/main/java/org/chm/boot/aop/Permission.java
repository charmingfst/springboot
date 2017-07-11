package org.chm.boot.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限控制
 * Created by charming on 2017/7/7.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Permission {
    /**
     * 是否需要登录，缺省为需要
     * @return
     */
    boolean loginReqired() default true;

    /**
     * 需要的权限，缺省值为不需要任何权限
     * @return
     */
    //Privilege privilege() default Privilege.ANY;
}
