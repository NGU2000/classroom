package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SubjectService extends IService<Subject> {
    //显示所有的子课程
    List<Subject> selectChildSubject(Long id);

    //导出文件操作
    void exportData(HttpServletResponse response);

    //导入文件操作
    void importData(MultipartFile multipartFile);
}
