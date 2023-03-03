package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.swagger.com.atguigu.ggkt.Result;
import com.atguigu.ggkt.vod.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "课堂分类管理")
@RestController
@RequestMapping("/admin/vod/subject")
@CrossOrigin
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    //课程分类列表接口
    @ApiOperation("课程分类列表")
    @GetMapping("getSubject/{id}")
    public Result getChildSubject(@PathVariable Long id){
        List<Subject> list = subjectService.selectChildSubject(id);
        return Result.success(list);
    }

    //课程导出接口
    @ApiOperation("课程导出接口")
    @GetMapping("/exportData")
    public Result exportCourseData(HttpServletResponse response){
        subjectService.exportData(response);
        return Result.success();
    }

    //课程导入接口
    @ApiOperation("课程导入接口")
    @PostMapping("importData")
    public Result importCourseData(){

        return Result.success();
    }
}
