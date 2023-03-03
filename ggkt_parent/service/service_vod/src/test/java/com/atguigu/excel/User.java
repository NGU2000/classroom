package com.atguigu.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class User {

    @ExcelProperty(value="id")
    private int id;

    @ExcelProperty(value="name")
    private String name;

}
