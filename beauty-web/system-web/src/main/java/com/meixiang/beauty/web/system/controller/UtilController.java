/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.web.system.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.utils.OSSObjectTool;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 工具 Controller
 *
 * @author ThinkGem
 * @version 2013-10-17
 */
@Controller
@RequestMapping(value = "system")
public class UtilController extends BaseController {

    /**
     * 上传文件
     * @param file
     * @param
     * @return {"status","success"}
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value="/uploadMediaFile",method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public ResponseDTO UploadFile(@RequestParam("file") MultipartFile file, String fileName) throws UnsupportedEncodingException {
        ResponseDTO response = new ResponseDTO();
        String path=fileName;
        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        try {
            file.transferTo(newFile);
            OSSObjectTool.uploadFileInputStream(path,newFile.length(),new FileInputStream(newFile),"yhllaoyou");
            response.setErrorInfo("上传成功");
            response.setResult(StatusConstant.SUCCESS);
            response.setResult(path);
        } catch (IOException e) {
            e.printStackTrace();
            response.setErrorInfo("上传失败");
            response.setResult(StatusConstant.FAILURE);
        }
        return response;
    }

}
