package io.renren.controller;
import io.renren.common.utils.Result;
import io.renren.dto.SysMvDTO;
import io.renren.service.SysMvService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("app/mv")
@Api(tags = "音视频管理")
public class AppMvController {
    @Autowired
    private SysMvService sysMvService;
    @GetMapping("mv")
    @RequiresPermissions("sys:user:info")
    public Result<List<SysMvDTO>> list(Map<String, Object> params) {
        List<SysMvDTO> data = sysMvService.list();
        return new Result<List<SysMvDTO>>().ok(data);
    }

}