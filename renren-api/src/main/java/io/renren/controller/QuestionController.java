package io.renren.controller;


import io.renren.annotation.LogOperation;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.utils.Result;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.dto.ArticleDTO;
import io.renren.dto.QuestionDTO;
import io.renren.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
@Api(tags = "问卷管理")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("question")
    @RequiresPermissions("sys:user:info")
    public Result<List<QuestionDTO>> list() {
        List<QuestionDTO> data = questionService.list();
        return new Result<List<QuestionDTO>>().ok(data);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    //@RequiresPermissions("user:info")
    public Result<QuestionDTO> get(@PathVariable("id") Long id){
        QuestionDTO data = questionService.get(id);
        return new Result<QuestionDTO>().ok(data);
    }


    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("user:save")
    public Result save(@RequestBody QuestionDTO dto){
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        questionService.save(dto);
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("user:update")
    public Result update(@RequestBody QuestionDTO dto){
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        questionService.update(dto);
        return new Result();
    }

}
