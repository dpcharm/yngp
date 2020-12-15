package com.yueniu.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yueniu.common.BaseCase;
import com.yueniu.service.LoginService;
import com.yueniu.utils.RestClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

@Listeners({com.yueniu.config.AssertListener.class})
public class DuanXianBaoCase extends BaseCase {

    @Resource
    private LoginService loginService;


    /**
     * 短线宝首页今日入选/入选监控
     * @throws IOException
     */
    @Test
    public void duanXianBaoHomePage() throws IOException {
        String url = ResourceBundle.getBundle("url/url", Locale.CHINA).getString("duanXianBao.url");
        String centralToken = loginService.getCentralToken();
        String entityString = "os=1&"+centralToken;
        HashMap<String,String> headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        CloseableHttpResponse response = RestClient.get(url, entityString, headerMap);
        String responseString = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject json = JSON.parseObject(responseString);
        String status = json.getString("status");

        System.out.println("json:"+json);

        Assert.assertEquals(status,"1","短线宝首页信息期望值与实际值不一致");

        System.out.println("111");


    }


}
