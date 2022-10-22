package io.renren.controller;
import io.renren.common.page.PageData2;
import io.renren.common.utils.Result;
import io.renren.dto.SysMvDTO;
import io.renren.service.SysMvService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("app")
@Api(tags = "音视频管理")
public class ApiMvController {
    @Autowired
    private SysMvService sysMvService;
    @GetMapping("mv")
    public Result<PageData2<SysMvDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData2<SysMvDTO> page = sysMvService.page(params);
        return new Result<PageData2<SysMvDTO>>().ok(page);
    }
}