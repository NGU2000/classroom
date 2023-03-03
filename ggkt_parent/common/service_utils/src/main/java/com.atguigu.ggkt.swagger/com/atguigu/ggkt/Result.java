package com.atguigu.ggkt.swagger.com.atguigu.ggkt;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="统一返回结果")
public class Result<T> {

    @ApiModelProperty(value="状态码")
    private Integer code; // 状态码

    @ApiModelProperty(value = "返回消息")
    private String message;//返回状态信息

    @ApiModelProperty(value= "返回数据")
    private T data;//返回的数据


    public Result(){

    }

    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = new Result<T>();
        if (body != null) {
            result.setData(body);
        }
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    //成功的方法,没有data数据
    public static<T> Result<T> success(){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("succeess");
        return result;
    }

    //失败的方法,没有data数据
    public static<T> Result<T>  fail(){
        Result<T> result = new Result<>();
        result.setCode(201);
        result.setMessage("fail");
        return result;
    }

    //成功的方法,有data数据
    public static<T> Result<T> success(T data){
        return build(data,20000,"success");
    }

    //失败的方法,有data数据
    public static<T> Result<T>  fail(T data){
        return build(data,20000,"fail");
    }

    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
