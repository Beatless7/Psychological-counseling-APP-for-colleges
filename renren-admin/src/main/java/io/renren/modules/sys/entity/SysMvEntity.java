package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
*音视频
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_mv")
public class SysMvEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 类型
     */
    private String types;
    /**
     * 地址
     */
    private String addr;
}
