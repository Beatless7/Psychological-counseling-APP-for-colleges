// powered by 天津理工大学心理辅导团队

package io.renren.modules.log.enums;

/**
 * 登录操作枚举
 *
 * @author Tjut team
 * @since 1.0.0
 */
public enum LoginOperationEnum {
    /**
     * 用户登录
     */
    LOGIN(0),
    /**
     * 用户退出
     */
    LOGOUT(1);

    private int value;

    LoginOperationEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}