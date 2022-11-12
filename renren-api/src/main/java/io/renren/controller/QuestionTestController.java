package io.renren.controller;


import io.renren.common.page.PageData2;
import io.renren.common.utils.Result;
import io.renren.dto.QuestionTestDTO;
import io.renren.service.QuestionTestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.Map;

@RestController
@RequestMapping("/app")
@Api(tags = "问卷管理")
public class QuestionTestController {
    @Autowired
    private QuestionTestService questionTestService;
    @GetMapping("questiontest")
    public Result<PageData2<QuestionTestDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData2<QuestionTestDTO> page = questionTestService.page(params);
        return new Result<PageData2<QuestionTestDTO>>().ok(page);
    }

}
