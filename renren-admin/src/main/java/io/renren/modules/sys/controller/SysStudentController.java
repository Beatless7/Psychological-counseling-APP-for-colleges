// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.controller;

import io.renren.common.annotation.LogOperation;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.Result;
import io.renren.common.validator.AssertUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.sys.dto.SysStudentDTO;
import io.renren.modules.sys.excel.SysUserExcel;
import io.renren.modules.sys.service.SysStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 学生管理
 */
@RestController
@RequestMapping("/sys/student")
@Api(tags="学生管理")
public class SysStudentController {
	@Autowired
	private SysStudentService sysStudentService;

	@GetMapping("page")
	@ApiOperation("分页")
	@ApiImplicitParams({
		@ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
		@ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
		@ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
		@ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String") ,
		@ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType="String"),
		@ApiImplicitParam(name = "gender", value = "性别", paramType = "query", dataType="String"),
		@ApiImplicitParam(name = "deptId", value = "部门ID", paramType = "query", dataType="String")
	})
	@RequiresPermissions("sys:user:page")
	public Result<PageData<SysStudentDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
		PageData<SysStudentDTO> page = sysStudentService.page(params);
		return new Result<PageData<SysStudentDTO>>().ok(page);
	}

	@GetMapping("{id}")
	@ApiOperation("信息")
	@RequiresPermissions("sys:user:info")
	public Result<SysStudentDTO> get(@PathVariable("id") Long id){
		SysStudentDTO data = sysStudentService.get(id);
		return new Result<SysStudentDTO>().ok(data);
	}


	@PostMapping
	@ApiOperation("保存")
	@LogOperation("保存")
	@RequiresPermissions("sys:user:save")
	public Result save(@RequestBody SysStudentDTO dto){
		ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
		sysStudentService.save(dto);
		return new Result();
	}

	@PutMapping
	@ApiOperation("修改")
	@LogOperation("修改")
	@RequiresPermissions("sys:user:update")
	public Result update(@RequestBody SysStudentDTO dto){
		ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
		sysStudentService.update(dto);
		return new Result();
	}

	@DeleteMapping
	@ApiOperation("删除")
	@LogOperation("删除")
	@RequiresPermissions("sys:user:delete")
	public Result delete(@RequestBody Long[] ids){
		AssertUtils.isArrayEmpty(ids, "id");
		sysStudentService.deleteBatchIds(Arrays.asList(ids));
		return new Result();
	}

	@GetMapping("export")
	@ApiOperation("导出")
	@LogOperation("导出")
	@RequiresPermissions("sys:user:export")
	@ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType="String")
	public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
		List<SysStudentDTO> list = sysStudentService.list(params);
		ExcelUtils.exportExcelToTarget(response, null, list, SysUserExcel.class);
	}
}