// powered by 天津理工大学心理辅导团队

package io.renren.service;

import io.renren.commons.dynamic.datasource.annotation.DataSource;
import io.renren.modules.sys.dao.SysUserDao;
import io.renren.modules.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试多数据源
 *
 * @author Tjut team
 */
@Service
//@DataSource("slave1")
public class DynamicDataSourceTestService {
    @Autowired
    private SysUserDao sysUserDao;

    //@Transactional
    public void updateUser(Long id){
        SysUserEntity user = new SysUserEntity();
        user.setId(id);
        user.setMobile("13500000000");
        //sysUserDao.updateById(user);
        System.out.println(sysUserDao.selectById(id));
    }

    @DataSource("slave1")
    @Transactional
    public void updateUserBySlave1(Long id){
        SysUserEntity user = new SysUserEntity();
        user.setId(id);
        user.setMobile("13500000001");
        //sysUserDao.updateById(user);
        System.out.println(sysUserDao.selectById(id));
    }

//    @DataSource("slave2")
//    @Transactional
//    public void updateUserBySlave2(Long id){
//        SysUserEntity user = new SysUserEntity();
//        user.setId(id);
//        user.setMobile("13500000002");
//        sysUserDao.updateById(user);
//
//        //测试事物
//        int i = 1/0;
//    }
}