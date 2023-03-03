package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.swagger.com.atguigu.ggkt.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/vod/user")
@CrossOrigin
public class LoginController {

    //登录
    @PostMapping("login")
    public Result login(){
        Map<String, Object>  map = new HashMap<>();
        map.put("token","admin");
        return Result.success(map);
    }

    //获取用户信息
    @GetMapping("info")
    public Result info(){
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","Super Admin");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        return Result.success(map);
    }

    //登出
    @PostMapping("logout")
    public Result logout(){
        return Result.success();
    }
}
