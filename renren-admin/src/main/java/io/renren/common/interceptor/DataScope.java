// powered by 天津理工大学心理辅导团队

package io.renren.common.interceptor;

/**
 * 数据范围
 *
 * @author Tjut team
 * @since 1.0.0
 */
public class DataScope {
    private String sqlFilter;

    public DataScope(String sqlFilter) {
        this.sqlFilter = sqlFilter;
    }

    public String getSqlFilter() {
        return sqlFilter;
    }

    public void setSqlFilter(String sqlFilter) {
        this.sqlFilter = sqlFilter;
    }

    @Override
    public String toString() {
        return this.sqlFilter;
    }
}