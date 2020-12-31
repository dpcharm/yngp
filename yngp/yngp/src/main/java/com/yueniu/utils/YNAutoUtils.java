package com.yueniu.utils;

import java.util.Date;

public class YNAutoUtils {

    /**
     * 策略名称自动生成  策略+时间戳
     * @return
     */
    public static String strategyNameGenerate(){

        Date date = new Date();
        long timeStamp = date.getTime();
        System.out.println("timeStamp:"+timeStamp);
        String stringTimeStamp = String.valueOf(timeStamp);
        String substring = stringTimeStamp.substring(7, 13);
        System.out.println(substring);

        String strategyName = "策略"+substring;
        System.out.println(strategyName);
        return strategyName;
    }


}
