package io.renren.controller;


import io.renren.annotation.LogOperation;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.utils.Result;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
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

import java.util.Map;

@RestController
@RequestMapping("/question")
@Api(tags = "问卷管理")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String") ,
            @ApiImplicitParam(name = "id", value = "编号", paramType = "query", dataType="int"),
            @ApiImplicitParam(name = "problems", value = "题目", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "yes", value = "yes", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "maybe", value = "maybe", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "no", value = "no", paramType = "query", dataType="String")
    })
    @RequiresPermissions("user:page")
    public Result<PageData<QuestionDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<QuestionDTO> page = questionService.page(params);
        return new Result<PageData<QuestionDTO>>().ok(page);
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
