package com.jxxy.mlxc.web.auth.controller;

import com.jxxy.mlxc.web.auth.util.ImageUtils;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * @Project:mlxc-parent
 * @Class:PictureController
 * @author:zhouyangmin
 * @CreateTime:2019年04月28日19:20
 * @Description:图片控制器
 * @Version: 1.0.0
 */
@Controller
@Slf4j
@RequestMapping("/mlxc")
public class PictureController {

    @PostMapping("/compoundPic.do")
    @ResponseBody
    public Object compoundPicture(HttpServletRequest request, @RequestParam("picPath")String picPath) throws IOException {
        String imgPath="D://img/";
        String path=null;
        if(!new File(imgPath+picPath).exists()){
            return new BaseReturnDto<>(ReturnCode.FAIL_SYSTEM.getCode(),"服务器异常，图片消失");
        }
        String savePath = request.getSession().getServletContext().getRealPath("/upload");
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        // 获取multiRequest 中所有的文件名
        Iterator<String> iter = multiRequest.getFileNames();
        while (iter.hasNext()) {
            // 一次遍历所有文件
            MultipartFile file = multiRequest.getFile(iter.next().toString());
            if (file != null) {
                Date day = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                String time = df.format(day);
                String fileOrigName = file.getOriginalFilename();
                int index = fileOrigName.lastIndexOf('.');
                String end = fileOrigName.substring(index, fileOrigName.length());
                path = savePath + "\\" + file.getOriginalFilename().substring(0, index) + "_" + time + end;
                // 上传
                //file.transferTo(new File(path));
                BufferedImage waterImg= ImageIO.read(file.getInputStream());
                BufferedImage img=ImageIO.read(new FileInputStream(imgPath+picPath));
                ImageUtils newImageUtils = new ImageUtils();
                // 构建叠加层
                BufferedImage buffImg = ImageUtils.watermark(img, waterImg, 100, 200, 1.0f);
                newImageUtils.generateWaterFile(buffImg, path);
            }
        }
        return new BaseReturnDto<>(ReturnCode.SUCCESS,path);
    }
}
