// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.enums;

/**
 * 菜单类型枚举
 *
 * @author Tjut team
 * @since 1.0.0
 */
public enum MenuTypeEnum {
    /**
     * 菜单
     */
    MENU(0),
    /**
     * 按钮
     */
    BUTTON(1);

    private int value;

    MenuTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
