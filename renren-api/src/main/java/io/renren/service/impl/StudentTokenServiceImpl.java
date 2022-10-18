package io.renren.service.impl;


import io.renren.annotation.LoginStudent;
import io.renren.common.service.impl.BaseServiceImpl;

import io.renren.dao.StudentTokenDao;
import io.renren.entity.StudentTokenEntity;
import io.renren.service.StudentTokenService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class StudentTokenServiceImpl extends BaseServiceImpl<StudentTokenDao, StudentTokenEntity> implements StudentTokenService {
    /**
     * 12小时后过期
     */
    private final static int EXPIRE = 3600 * 12;

    @Override
    public StudentTokenEntity getByToken(String token) {
        return baseDao.getByToken(token);
    }

    @Override
    public StudentTokenEntity createToken(Long studentId) {
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //用户token
        String token;

        //判断是否生成过token
        StudentTokenEntity tokenEntity = baseDao.getByStudentId(studentId);
        if(tokenEntity == null){
            //生成一个token
            token = generateToken();

            tokenEntity = new StudentTokenEntity();
            tokenEntity.setStudentId(studentId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateDate(now);
            tokenEntity.setExpireDate(expireTime);

            //保存token
            this.insert(tokenEntity);
        }else{
            //判断token是否过期
            if(tokenEntity.getExpireDate().getTime() < System.currentTimeMillis()){
                //token过期，重新生成token
                token = generateToken();
            }else {
                token = tokenEntity.getToken();
            }

            tokenEntity.setToken(token);
            tokenEntity.setUpdateDate(now);
            tokenEntity.setExpireDate(expireTime);

            //更新token
            this.updateById(tokenEntity);
        }

        return tokenEntity;
    }

    @Override
    public void expireToken(Long studentId){
        Date now = new Date();

        StudentTokenEntity tokenEntity = new StudentTokenEntity();
        tokenEntity.setStudentId(studentId);
        tokenEntity.setUpdateDate(now);
        tokenEntity.setExpireDate(now);

        this.updateById(tokenEntity);
    }

    private String generateToken(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
