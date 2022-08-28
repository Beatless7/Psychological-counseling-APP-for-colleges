// powered by 天津理工大学心理辅导团队

package io.renren.dao;

import java.util.List;
import java.util.Map;

/**
 * 数据库接口
 *
 * @author Tjut team
 */
public interface GeneratorDao {
    List<Map<String, Object>> queryList(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
