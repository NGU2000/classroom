package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.swagger.com.atguigu.ggkt.Result;
import com.atguigu.ggkt.exception.selfDefinedException;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.netty.util.internal.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//返回统一结果，用类封装
@Api(tags = "讲师接口")
@RestController
@RequestMapping(value = "/admin/vod/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

//    //1查询所有讲师
//    @ApiOperation("查询所有讲师")
//    @GetMapping("findAll")
//    public List<Teacher> findAll(){
//        List<Teacher> list = teacherService.list();
//        return list;
//    }


    //1查询所有讲师
    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public Result findAll(){
        List<Teacher> list = teacherService.list();
        return Result.success(list);
    }

    //2逻辑删除所有讲师
    @ApiOperation("删除所有讲师")
    @DeleteMapping("remove/{id}")
    public Result removeTeacher(@ApiParam(name = "id",value = "ID",required = true) @PathVariable Long id){
        boolean isSuccessful = teacherService.removeById(id);
        if(isSuccessful){
            return Result.success();
        }
        else{
            return Result.fail();
        }
    }

    //3查询分页接口
    @ApiOperation("查询分页")
    @PostMapping("findQueryPage/{current}/{limit}")
    public Result findPage(@PathVariable long current,
                           @PathVariable long limit,
                           TeacherQueryVo teacherQueryVo){
        //创建Page对象
        //判断teacherQueryVo对象是否为空
        //进行非空判断，条件封装
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        Page<Teacher> pageParam = new Page<>(current,limit);
        if(teacherQueryVo == null){
            IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
            return Result.success(pageModel);
        }
        else{
            String name = teacherQueryVo.getName();
            Integer level = teacherQueryVo.getLevel();
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();
            //如果name不为空
            if(!StringUtils.isEmpty(name)){
                wrapper.like("name",name);
            }
//            if(!StringUtils.isEmpty(String.valueOf(level))){
//                wrapper.eq("level",level);
//            }
            if(!StringUtils.isEmpty(joinDateBegin)){
                wrapper.ge("join_date",joinDateBegin);
            }
            if(!StringUtils.isEmpty(joinDateEnd)){
                wrapper.le("join_date",joinDateEnd);
            }
            IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
            return Result.success(pageModel);
        }
    }

    //添加讲师接口
    @ApiOperation(value = "添加讲师")
    @PostMapping("save")
    public Result save(@RequestBody Teacher teacher){
        teacherService.save(teacher);
        return Result.success();
    }

    //通过ID查询讲师接口
    @ApiOperation(value = "获取讲师信息")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        Teacher teacher = teacherService.getById(id);
        return Result.success(teacher);
    }
    //修改讲师接口
    @ApiOperation(value = "修改讲师")
    @PutMapping("revise")
    public Result reverseById(@RequestBody Teacher teacher){
        teacherService.updateById(teacher);
        return Result.success();
    }

    //批量删除讲师接口
    @ApiOperation(value = "批量删除")
    @DeleteMapping("batchDelete")
    public Result batchRemove(@RequestBody List<Long> idList){
        teacherService.removeByIds(idList);
        return Result.success();
    }
}

