// powered by 天津理工大学心理辅导团队

package io.renren.annotation;

import java.lang.annotation.*;

/**
 * 登录效验
 * @author Tjut team
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
