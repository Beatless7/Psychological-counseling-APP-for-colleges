package io.renren.modules.sys.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/*
统计管理
 */
@RestController
@Api(tags="统计管理")
@RequestMapping("/sys/smt")
public class SysSmtController {

    public String save(){
        System.out.println("save");
        return "{'123'}";
    }
}