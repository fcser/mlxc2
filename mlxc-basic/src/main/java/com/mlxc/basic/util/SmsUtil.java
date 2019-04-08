package com.mlxc.basic.util;

import com.alibaba.fastjson.JSONObject;
import com.mlxc.basic.message.Config;
import com.mlxc.basic.message.HttpUtils;

import java.net.URLEncoder;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @project: beautifulcountry
 * @class: SmsUtil
 * @author: zhouyangmin
 * @createDate: 2019年1月23日 上午10:52:24
 * @description:
 * @version: v1.0
 */
public class SmsUtil {

    private static String operation = "/industrySMS/sendSMS";

    private static String accountSid = Config.ACCOUNT_SID;

    /**
     *
     *@param:
     *@return:String
     *@throws:
     *@deprecated:生成验证码
     *
     */
    private static String verification() {
        String str="1234567890";
        Random rd= ThreadLocalRandom.current();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<6;i++) {
            int index=rd.nextInt(10);
            sb.append(str.charAt(index));
        }
        return sb.toString();

    }

    /**
     * 产生短信内容
     */
    private static String message(String verification,int time) {
        return "【阳光科技】您的验证码为"+verification+"，请于"+time+"分钟内正确输入，如非本人操作，请忽略此短信。";
    }
    /**
     *
     * @param phone
     * @return 验证码
     */
    public static String execute(String phone,int time)
    {
        String verification=SmsUtil.verification();
        String smsContent=SmsUtil.message(verification,time);
        String tmpSmsContent = null;
        try{
            tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
        }catch(Exception e){

        }
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + "&to=" + phone + "&smsContent=" + tmpSmsContent
                + HttpUtils.createCommonParam();

        // 提交请求
        String result = HttpUtils.post(url, body);
        System.out.println("result:" + System.lineSeparator() + result);
        if(!result.isEmpty()) {
            JSONObject js= JSONObject.parseObject(result);
            String isOk=js.getString("respDesc");
            if(("请求成功。").equals(isOk)) {
                return verification;
            }
        }
        return "fail";//消息未成功发送
    }
    /**
     *
     *@param:
     *@return:void
     *@throws:
     *@deprecated:
     *	{"respCode":"00000","respDesc":"请求成功。","failCount":"0","failList":[],"smsId":"d25f5f7ef17943848cc56f47951a64e6"}
     */
    public static void main(String[] args){
        //System.out.println("验证码:");
        System.out.println("验证码:"+SmsUtil.execute("15857354568",1));
    }
}
