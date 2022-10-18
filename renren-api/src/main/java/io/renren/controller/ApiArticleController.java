package io.renren.controller;
import io.renren.common.utils.Result;
import io.renren.dto.ArticleDTO;
import io.renren.service.ArticleService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("app")
@Api(tags = "音视频管理")
public class ApiArticleController {
    @Autowired
    private ArticleService ArticleService;
    @GetMapping("article")
    @RequiresPermissions("sys:user:info")
    public Result<List<ArticleDTO>> list() {
        List<ArticleDTO> data = ArticleService.list();
        return new Result<List<ArticleDTO>>().ok(data);
    }

}