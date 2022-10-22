package io.renren.controller;


import io.renren.common.page.PageData2;
import io.renren.common.utils.Result;
import io.renren.dto.QuestionDTO;
import io.renren.service.QuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.Map;

@RestController
@RequestMapping("/app")
@Api(tags = "问卷管理")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("question")
    public Result<PageData2<QuestionDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData2<QuestionDTO> page = questionService.page(params);
        return new Result<PageData2<QuestionDTO>>().ok(page);
    }

}
