package com.yueniu.common;

import java.util.Locale;
import java.util.ResourceBundle;

public class YNXpath {
   static ResourceBundle bundle = ResourceBundle.getBundle("url/yngp_element_xpath", Locale.CHINA);


    /**
     * 根据传入的枚举类型Xpath，获取配置文件中的xpath值
     * @param xpathEnum
     * @return
     */
    public static String getXpath(YNXpathEnum xpathEnum){
        String xPath = bundle.getString(String.valueOf(xpathEnum));
        return xPath;
    }

}
