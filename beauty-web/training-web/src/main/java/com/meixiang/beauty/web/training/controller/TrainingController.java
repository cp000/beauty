package com.meixiang.beauty.web.training.controller;

import com.meixiang.beauty.sys.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

@Controller
@RequestMapping(value = "")
public class TrainingController {

    @Autowired
    private SystemService systemService;


}
