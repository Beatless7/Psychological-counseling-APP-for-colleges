// powered by 天津理工大学心理辅导团队

package io.renren.modules.log.enums;

/**
 * 登录状态枚举
 *
 * @author Tjut team
 * @since 1.0.0
 */
public enum LoginStatusEnum {
    /**
     * 失败
     */
    FAIL(0),
    /**
     * 成功
     */
    SUCCESS(1),
    /**
     * 账号已锁定
     */
    LOCK(2);

    private int value;

    LoginStatusEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
