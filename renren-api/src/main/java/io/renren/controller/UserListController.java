package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.Result;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.dto.UserListDTO;
import io.renren.entity.UserEntity;
import io.renren.service.UserListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/teacher")
@Api(tags = "教师管理")
public class UserListController {
    @Autowired
    private UserListService userListService;

    @Login
    @GetMapping("/user/userInfo")
    @ApiOperation(value="获取教师管理员信息", response= UserEntity.class)
    public Result<UserEntity> userInfo(@ApiIgnore @LoginUser UserEntity user){
        return new Result<UserEntity>().ok(user);
    }

    @PutMapping("/user/update")
    @ApiOperation("修改")
    public Result update(@RequestBody UserListDTO dto){
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        userListService.update(dto);
        return new Result();
    }
//
//    @GetMapping("page")
//    @RequiresPermissions("sys:user:info")
//    public Result<List<UserListDTO>> list() {
//        List<UserListDTO> data = userListService.list();
//        return new Result<List<UserListDTO>>().ok(data);
//    }

}
