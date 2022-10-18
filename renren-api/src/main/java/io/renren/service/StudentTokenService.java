package io.renren.service;


import io.renren.common.service.BaseService;
import io.renren.entity.StudentTokenEntity;

/**
 * 学生Token
 *
 * @author Tjut team
 */
public interface StudentTokenService extends BaseService<StudentTokenEntity> {
    StudentTokenEntity getByToken(String token);

    /**
     * 生成token
     * @param studentId  用户ID
     * @return        返回token信息
     */
    StudentTokenEntity createToken(Long studentId);

    /**
     * 设置token过期
     * @param studentId 用户ID
     */
    void expireToken(Long studentId);
}
