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
@TableName("sys_MV")
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
    /*
        封面地址
    * */
    private String addr2;
    /*
    *  标题
    * */
    private String title;
}
