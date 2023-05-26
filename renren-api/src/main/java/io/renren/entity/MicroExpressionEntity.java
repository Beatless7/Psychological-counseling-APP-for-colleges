package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;


@Data
@TableName("Expression")
public class MicroExpressionEntity {

    private float angry;

    private float disgusted;

    private float fearful;

    private float happy;

    private float sad;

    private float surprised;

    private float neutral;

}
