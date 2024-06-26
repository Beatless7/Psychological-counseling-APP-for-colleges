package io.renren.controller;

import io.renren.entity.MicroExpressionEntity;
import io.renren.service.MicroExpressionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/microExpression")
@Api(tags = "微表情识别")
public class MicroExpressionController {

    @Autowired
    private MicroExpressionService microExpressionService;

    @GetMapping("/result")
    @ApiOperation(value = "传递用户微表情信息", response = MicroExpressionEntity.class)
    public List<MicroExpressionEntity> expressionResult() {
        List<MicroExpressionEntity> ExpResult = microExpressionService.showExpressionResult();
        if (ExpResult.size()==0) {
            List EmptyResult = new ArrayList();

            return EmptyResult;
        } else {
            return ExpResult;
        }
    }

}
