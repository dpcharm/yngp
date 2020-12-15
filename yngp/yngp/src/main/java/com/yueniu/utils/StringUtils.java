package com.yueniu.utils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class StringUtils {


    @Resource
    private static ResourceBundle bundle = ResourceBundle.getBundle("url/url", Locale.CHINA);

    /**
     * 获取登录的请求参数
     * @param userName
     * @param passwd
     * @return
     */
    public static String getLoginParam(String userName, String passwd) {

        String app_version = bundle.getString("app_version");
        String os = bundle.getString("os");
        String systemcode = bundle.getString("systemcode");
        String os_version = bundle.getString("os_version");
        String channel = bundle.getString("channel");
        String deviceId = bundle.getString("deviceId");
        String special = bundle.getString("special");
        String password = passwd;
        String phoneNumber = userName;
        String app_version_code = bundle.getString("app_version_code");
        String registrationID = bundle.getString("registrationID");
        String model = bundle.getString("model");
        String brand = bundle.getString("brand");
        String androidId = bundle.getString("androidId");
        String oaid = bundle.getString("oaid");

        String loginParam = "app_version=" + app_version + "&" +
                "os=" + os + "&" +
                "systemcode=" + systemcode + "&" +
                "os_version=" + os_version + "&" +
                "channel=" + channel + "&" +
                "deviceId=" + deviceId + "&" +
                "special=" + special + "&" +
                "password=" + password + "&" +
                "phoneNumber=" + phoneNumber + "&" +
                "app_version_code=" + app_version_code + "&" +
                "registrationID=" + registrationID + "&" +
                "model=" + model + "&" +
                "brand=" + brand + "&" +
                "androidId=" + androidId + "&" +
                "oaid=" + oaid;
        return loginParam;
    }

    /**
     * 获取首页-关注的请求参数
     * @param token
     * @return
     */
    public static String getAttentionParam(String token) {

        String app_version = bundle.getString("app_version");
        String os = bundle.getString("os");
        String systemcode = bundle.getString("systemcode");
        String os_version = bundle.getString("os_version");
        String channel = bundle.getString("channel");
        String pageSize = bundle.getString("pageSize");
        String deviceId = bundle.getString("deviceId");
        String special = bundle.getString("special");
        String app_version_code = bundle.getString("app_version_code");
        String registrationID = bundle.getString("registrationID");
        String model = bundle.getString("model");
        String page = bundle.getString("page");
        String centralToken = token;
        String brand = bundle.getString("brand");
        String androidId = bundle.getString("androidId");
        String oaid = bundle.getString("oaid");

        String attentionParam = "app_version=" + app_version + "&" +
                "os=" + os + "&" +
                "systemcode=" + systemcode + "&" +
                "os_version=" + os_version + "&" +
                "channel=" + channel + "&" +
                "pageSize=" + pageSize + "&" +
                "deviceId=" + deviceId + "&" +
                "special=" + special + "&" +
                "app_version_code=" + app_version_code + "&" +
                "registrationID=" + registrationID + "&" +
                "model=" + model + "&" +
                "page=" + page + "&" +
                "centralToken=" + centralToken + "&" +
                "brand=" + brand + "&" +
                "androidId=" + androidId + "&" +
                "oaid=" + oaid;

        return attentionParam;
    }

    /**
     * 获取首页-热点事件的请求参数
     * @return
     */
    public static String getHotEventsParam() {

        String app_version = bundle.getString("app_version");
        String os = bundle.getString("os");
        String systemcode = bundle.getString("systemcode");
        String os_version = bundle.getString("os_version");
        String channel = bundle.getString("hotEvemts.channel");
        String deviceId = bundle.getString("deviceId");
        String special = bundle.getString("special");
        String size = bundle.getString("size");

        String app_version_code = bundle.getString("app_version_code");
        String limit = bundle.getString("limit");
        String registrationID = bundle.getString("registrationID");
        String model = bundle.getString("model");
        String brand = bundle.getString("brand");
        String androidId = bundle.getString("androidId");
        String oaid = bundle.getString("oaid");


        String hotEventsParam = "app_version=" + app_version + "&" +
                "os=" + os + "&" +
                "systemcode=" + systemcode + "&" +
                "os_version=" + os_version + "&" +
                "channel=" + channel + "&" +
                "deviceId=" + deviceId + "&" +
                "special=" + special + "&" +
                "size=" + size + "&" +
                "app_version_code=" + app_version_code + "&" +
                "limit=" + limit + "&" +
                "registrationID=" + registrationID + "&" +
                "model=" + model + "&" +
                "brand=" + brand + "&" +
                "androidId=" + androidId + "&" +
                "oaid=" + oaid;

        return hotEventsParam;
    }

    /**
     * 获取首页-涨停分析请求的参数
     * @return
     */

    public static String getPriceLimitAnalysisParam() {

        String app_version = bundle.getString("app_version");
        String os = bundle.getString("os");
        String systemcode = bundle.getString("systemcode");
        String os_version = bundle.getString("os_version");
        String channel = bundle.getString("hotEvemts.channel");
        String deviceId = bundle.getString("deviceId");
        String special = bundle.getString("special");
        String size = bundle.getString("size");

        String app_version_code = bundle.getString("app_version_code");
        String limit = bundle.getString("priceLimitAnalysis.limit");
        String registrationID = bundle.getString("registrationID");
        String model = bundle.getString("model");
        long time = new Date().getTime();
        String brand = bundle.getString("brand");
        String androidId = bundle.getString("androidId");
        String oaid = bundle.getString("oaid");

        String priceLimitAnalysisParam = "app_version=" + app_version + "&" +
                "os=" + os + "&" +
                "systemcode=" + systemcode + "&" +
                "os_version=" + os_version + "&" +
                "channel=" + channel + "&" +
                "deviceId=" + deviceId + "&" +
                "special=" + special + "&" +
                "size=" + size + "&" +
                "app_version_code=" + app_version_code + "&" +
                "limit=" + limit + "&" +
                "registrationID=" + registrationID + "&" +
                "model=" + model + "&" +
                "time=" + time + "&" +
                "brand=" + brand + "&" +
                "androidId=" + androidId + "&" +
                "oaid=" + oaid;

        return priceLimitAnalysisParam;
    }

    /**
     * 获取首页-推荐的请求参数
     * @return
     */
    public static String getRecommendParam() {

        String app_version = bundle.getString("app_version");
        String os = bundle.getString("os");
        String systemcode = bundle.getString("systemcode");
        String os_version = bundle.getString("os_version");
        String channel = bundle.getString("hotEvemts.channel");
        String pageSize = bundle.getString("pageSize");
        String deviceId = bundle.getString("deviceId");
        String special = bundle.getString("special");
        String app_version_code = bundle.getString("app_version_code");
        String registrationID = bundle.getString("registrationID");
        String model = bundle.getString("model");
        String page = bundle.getString("page");
        String brand = bundle.getString("brand");
        String androidId = bundle.getString("androidId");
        String oaid = bundle.getString("oaid");

        String recommendParam = "app_version=" + app_version + "&" +
                "os=" + os + "&" +
                "systemcode=" + systemcode + "&" +
                "os_version=" + os_version + "&" +
                "channel=" + channel + "&" +
                "pageSize=" + pageSize + "&" +
                "deviceId=" + deviceId + "&" +
                "special=" + special + "&" +
                "app_version_code=" + app_version_code + "&" +
                "registrationID=" + registrationID + "&" +
                "model=" + model + "&" +
                "page=" + page + "&" +
                "brand=" + brand + "&" +
                "androidId=" + androidId + "&" +
                "oaid=" + oaid;

        return recommendParam;
    }


}
