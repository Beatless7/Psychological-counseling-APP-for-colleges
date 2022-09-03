// powered by 天津理工大学心理辅导团队

package io.renren.modules.log.enums;

/**
 * 操作状态枚举
 *
 * @author Tjut team
 * @since 1.0.0
 */
public enum OperationStatusEnum {
    /**
     * 失败
     */
    FAIL(0),
    /**
     * 成功
     */
    SUCCESS(1);

    private int value;

    OperationStatusEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}