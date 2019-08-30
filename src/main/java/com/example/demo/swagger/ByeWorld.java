package com.example.demo.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：lejb
 * @date ：Created in 2019/8/30 10:09
 */
@Api("SwaggerBye接口")
@RestController
@RequestMapping("bye")
public class ByeWorld {


    @ApiOperation(value = "下载图片",notes = "文件不能超过20M大小，后缀名为png，jpg，gif")
    @RequestMapping(value = "/downloadImg",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam("file") String file) {
        System.out.println("上传图片");
        return file;
    }
}
