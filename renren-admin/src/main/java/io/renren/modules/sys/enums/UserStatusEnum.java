// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.enums;

/**
 * 用户状态
 *
 * @author Tjut team
 * @since 1.0.0
 */
public enum UserStatusEnum {
    DISABLE(0),
    ENABLED(1);

    private int value;

    UserStatusEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
