package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginStudent;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.Result;
import io.renren.common.validator.ValidatorUtils;
import io.renren.dto.StuInfoDTO;
import io.renren.dto.UserInfoDTO;
import io.renren.entity.StudentEntity;
import io.renren.entity.UserEntity;
import io.renren.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/teacher")
@Api(tags = "教师基本信息")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Login
    @GetMapping("user/infos")
    @ApiOperation("基本信息")
    public Result<UserInfoDTO> getById(@ApiIgnore @LoginUser UserEntity user){
        UserInfoDTO data = userInfoService.getUserInfo(user.getId());

        return new Result<UserInfoDTO>().ok(data);
    }

    @Login
    @PutMapping("/user/updateinfo")
    @ApiOperation("修改基本信息")
    public Result updateStuInfo(@ApiIgnore @LoginUser UserEntity entity,@RequestBody UserInfoDTO dto){
        ValidatorUtils.validateEntity(dto);

        userInfoService.UpdateUserInfo(entity.getId(),dto);

        return new Result();
    }
}