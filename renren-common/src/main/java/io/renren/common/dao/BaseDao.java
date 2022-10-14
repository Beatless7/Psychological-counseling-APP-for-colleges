// powered by 天津理工大学心理辅导团队

package io.renren.common.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao
 *
 * @author Tjut team
 * @since 1.0.0
 */
public interface BaseDao<T> extends BaseMapper<T> {

}
