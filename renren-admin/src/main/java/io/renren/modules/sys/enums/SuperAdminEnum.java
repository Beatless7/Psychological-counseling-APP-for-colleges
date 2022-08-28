// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.enums;

/**
 * 超级管理员枚举
 *
 * @author Tjut team
 * @since 1.0.0
 */
public enum SuperAdminEnum {
    YES(1),
    NO(0);

    private int value;

    SuperAdminEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}