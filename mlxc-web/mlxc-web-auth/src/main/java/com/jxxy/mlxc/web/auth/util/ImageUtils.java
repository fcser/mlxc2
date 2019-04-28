package com.jxxy.mlxc.web.auth.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @Project:mlxc-parent
 * @Class:ImageUtils
 * @author:zhouyangmin
 * @CreateTime:2019年04月28日19:44
 * @Description:java图片处理类
 * @Version: 1.0.0
 */

public class ImageUtils {
    public static BufferedImage watermark(BufferedImage buffImg, BufferedImage waterImg, int x, int y, float alpha) throws IOException {         // 获取底图

        // 创建Graphics2D对象，用在底图对象上绘图
        Graphics2D g2d = buffImg.createGraphics();
        int a = waterImg.getWidth();// 获取层图的宽度
        int b = waterImg.getHeight();// 获取层图的高度

        int waterImgWidth = 300;// 获取层图的宽度
        int waterImgHeight = 300*a/b;


        // 在图形和图像中实现混合和透明效果
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        // 绘制
        //g2d.drawImage(buffImg, x, y, buffImgWidth, buffImgHeight, null);
        g2d.drawImage(waterImg, x, y, waterImgWidth, waterImgHeight, null);
        g2d.dispose();// 释放图形上下文使用的系统资源
        return buffImg;
    }

    public static String getRandom(int length)
    {
        String base="abcdefghijklmnopqrstuvwxyz0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++)
        {
            int number=random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 输出图片水印
     * @param buffImg
     * @param savePath
     */
    public void generateWaterFile(BufferedImage buffImg, String savePath) {
        int temp = savePath.lastIndexOf(".") + 1;
        try {
            ImageIO.write(buffImg, savePath.substring(temp), new File(savePath));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
