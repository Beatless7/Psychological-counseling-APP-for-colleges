// powered by 天津理工大学心理辅导团队

package io.renren.commons.dynamic.datasource.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 *
 * @author Tjut team
 * @since 1.0.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default "";
}
