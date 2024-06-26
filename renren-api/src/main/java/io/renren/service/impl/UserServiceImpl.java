// powered by 天津理工大学心理辅导团队

package io.renren.service.impl;

import io.renren.common.exception.ErrorCode;
import io.renren.common.exception.RenException;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.common.validator.AssertUtils;
import io.renren.dao.UserDao;
import io.renren.dto.StuRetDto;
import io.renren.entity.StudentEntity;
import io.renren.entity.TokenEntity;
import io.renren.entity.UserEntity;
import io.renren.dto.LoginDTO;
import io.renren.service.TokenService;
import io.renren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserEntity> implements UserService {
	@Autowired
	private TokenService tokenService;

	@Override
	public UserEntity getByMobile(String mobile) {
		return baseDao.getUserByMobile(mobile);
	}

	@Override
	public UserEntity getUserByUserId(Long userId) {
		return baseDao.getUserByUserId(userId);
	}

	@Override
	public Map<String, Object> login(LoginDTO dto) {
		UserEntity user = getByMobile(dto.getMobile());
		AssertUtils.isNull(user, ErrorCode.ACCOUNT_PASSWORD_ERROR);

		//密码错误
		if(!user.getPassword().equals(dto.getPassword())){
			throw new RenException(ErrorCode.ACCOUNT_PASSWORD_ERROR);
		}

		//获取登录token
		TokenEntity tokenEntity = tokenService.createToken(user.getId());

		Map<String, Object> map = new HashMap<>(2);
		map.put("token", tokenEntity.getToken());
		map.put("expire", tokenEntity.getExpireDate().getTime() - System.currentTimeMillis());

		return map;
	}

	@Override
	public List<StuRetDto> getStuAll(Long id) {
		List<StudentEntity> all = baseDao.getStuAll(id);
		return ConvertUtils.sourceToTarget(all,StuRetDto.class);
	}
}