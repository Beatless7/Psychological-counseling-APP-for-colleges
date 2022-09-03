package io.renren.modules.sys.controller;

import io.renren.common.annotation.LogOperation;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.utils.Result;
import io.renren.common.validator.AssertUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.sys.dto.SysQuestionDTO;
import io.renren.modules.sys.service.SysQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/sys/question")
@Api(tags = "问卷管理")
public class SysQuestionController {
    @Autowired
    private SysQuestionService sysQuestionService;
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
    @RequiresPermissions("sys:user:page")
    public Result<PageData<SysQuestionDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<SysQuestionDTO> page = sysQuestionService.page(params);
        return new Result<PageData<SysQuestionDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("sys:user:info")
    public Result<SysQuestionDTO> get(@PathVariable("id") Long id){
        SysQuestionDTO data = sysQuestionService.get(id);
        return new Result<SysQuestionDTO>().ok(data);
    }


    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("sys:user:save")
    public Result save(@RequestBody SysQuestionDTO dto){
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        sysQuestionService.save(dto);
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("sys:user:update")
    public Result update(@RequestBody SysQuestionDTO dto){
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        sysQuestionService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:user:delete")
    public Result delete(@RequestBody Long[] ids){
        AssertUtils.isArrayEmpty(ids, "id");
        sysQuestionService.deleteBatchIds(Arrays.asList(ids));
        return new Result();
    }
}
