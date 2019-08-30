package com.example.demo.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：lejb
 * @date ：Created in 2019/8/2 16:59
 */

@Api("SwaggerHello接口")
@RestController
@RequestMapping("hello")
public class HelloWorld {

    /**
     * 上传图片接口
     * @return imgSrc：上传后图片文件的路径
     */
    @ApiOperation(value = "上传图片",notes = "文件不能超过20M大小，后缀名为png，jpg，gif")
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam("file") String file) {
        System.out.println("上传图片");
        return file;
    }
}
