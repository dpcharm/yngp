package com.yueniu.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yueniu.common.BaseCase;
import com.yueniu.model.User;
import com.yueniu.service.LoginService;
import com.yueniu.utils.RestClient;
import com.yueniu.utils.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Listeners({com.yueniu.config.AssertListener.class})
public class LoginCase extends BaseCase {

    ResourceBundle bundle;
    public String centralToken;
    @Resource
    private LoginService loginService;

    /**
     * 登录
     * @throws IOException
     */
    @Test(groups = {"loginTrue"})
    public void loginTrue() throws IOException {

        String phoneNumber;
        String password;
        String entityString;
        String stringResponse;

        bundle = ResourceBundle.getBundle("url/url", Locale.CHINA);
        String url = bundle.getString("Login.URL");
        System.out.println(url);

        //Integer countUser = loginService.selectCountUser();

        List<User> users = loginService.getAllUser();
        System.out.println("user :"+users);
        for (User user : users) {
            if (user.getId().equals("1")) {
                phoneNumber = user.getUserName();
                password = user.getPasswd();
                entityString = StringUtils.getLoginParam(phoneNumber,password);
                HashMap<String, String> headerMap = new HashMap<>();
                headerMap.put("Content-Type", "application/x-www-form-urlencoded");
                CloseableHttpResponse response = RestClient.post(url, entityString, headerMap);
                stringResponse = EntityUtils.toString(response.getEntity(), "utf-8");
                JSONObject json = JSON.parseObject(stringResponse);
                centralToken = (String) json.getJSONObject("data").get("centralToken");
                //将centralToken存入数据库
                Integer result = loginService.addCentralTokenToUser(centralToken);
                if (result != 1){
                    return;
                }

                Integer statu = (Integer)json.get("status");
                int status = statu.intValue();
                Assert.assertEquals(status,1,"登陆失败！！！");
            }
        }
    }

    @Test
    public void loginFalse() throws IOException {

        String phoneNumber;
        String password;
        String entityString;
        String stringResponse;

        bundle = ResourceBundle.getBundle("url/url", Locale.CHINA);
        String url = bundle.getString("Login.URL");
        List<User> users = loginService.getAllUser();
        System.out.println("user :"+users);

        for (User user : users) {
            if (!user.getId().equals("1")) {
                phoneNumber = user.getUserName();
                password = user.getPasswd();
                entityString = StringUtils.getLoginParam(phoneNumber,password);
                HashMap<String, String> headerMap = new HashMap<>();
                headerMap.put("Content-Type", "application/x-www-form-urlencoded");
                CloseableHttpResponse response = RestClient.post(url, entityString, headerMap);
                stringResponse = EntityUtils.toString(response.getEntity(), "utf-8");
                JSONObject json = JSON.parseObject(stringResponse);
                Integer statu = (Integer)json.get("status");
                int status = statu.intValue();
                Assert.assertEquals(status,200002,"登陆失败！！！");
            }
        }
    }


    /**
     * 首页-关注
     * @throws IOException
     */
    @Test(dependsOnGroups = "loginTrue")
    public void attention() throws IOException {

        String url = ResourceBundle.getBundle("url/url",Locale.CHINA).getString("follow.url");


        String centralToken = loginService.getCentralToken();

        String entityString = StringUtils.getAttentionParam(centralToken);

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/x-www-form-urlencoded");

        CloseableHttpResponse response = RestClient.post(url, entityString, headerMap);

        String responseString = EntityUtils.toString(response.getEntity(), "utf-8");

        JSONObject json = JSON.parseObject(responseString);
        Object status = json.get("status");
        Object message = json.get("message");
        Assert.assertEquals(1,status,"关注页面返回状态码与期望值不一致");
        Assert.assertEquals("OK",message,"关注页面返回message与期望值不一致");
    }




    /**
     * 首页-热点事件
     */
    @Test
    public void hotEvents() throws IOException {
        String url = ResourceBundle.getBundle("url/url",Locale.CHINA).getString("hotEvents.url");
        String entityString = StringUtils.getHotEventsParam();
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/x-www-form-urlencoded");
        CloseableHttpResponse response = RestClient.post(url, entityString, headerMap);
        String responseString = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject json = JSON.parseObject(responseString);
        Object status = json.get("status");
        Assert.assertEquals(status,1,"热点事件status期望值与实际值不一致");
    }

    /**
     * 首页 涨停分析
     */
    @Test
    public void priceLimitAnalysis() throws IOException {
        String url = ResourceBundle.getBundle("url/url",Locale.CHINA).getString("priceLimitAnalysis.url");
        String entityString = StringUtils.getPriceLimitAnalysisParam();
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/x-www-form-urlencoded");
        CloseableHttpResponse response = RestClient.post(url, entityString, headerMap);
        String responseString = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject json = JSON.parseObject(responseString);
        System.out.println(json);
        Object status = json.get("status");
        Assert.assertEquals(status,1,"涨停分析status期望值与实际值不一致");
    }

    /**
     * 首页推荐
     */
    @Test
    public void recommend() throws IOException {
        String url = ResourceBundle.getBundle("url/url",Locale.CHINA).getString("recommend.url");
        String entityString = StringUtils.getRecommendParam();
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/x-www-form-urlencoded");
        CloseableHttpResponse response = RestClient.post(url, entityString, headerMap);
        String responseString = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject json = JSON.parseObject(responseString);
        System.out.println(json);
        Object status = json.get("status");
        Assert.assertEquals(status,1,"涨停分析status期望值与实际值不一致");
    }

    public void te(){

    }


}
