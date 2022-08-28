// powered by 天津理工大学心理辅导团队

package io.renren.common.annotation;

import java.lang.annotation.*;

/**
 * 数据过滤注解
 *
 * @author Tjut team
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataFilter {
    /**
     * 表的别名
     */
    String tableAlias() default "";

    /**
     * 用户ID
     */
    String userId() default "creator";

    /**
     * 部门ID
     */
    String deptId() default "dept_id";

}