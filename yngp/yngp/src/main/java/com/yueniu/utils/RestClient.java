package com.yueniu.utils;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {


    private CookieStore store;

    /**
     * 创建一个无参的get请求，返回响应
     * @return
     * @throws IOException
     */
//    public static CloseableHttpResponse get(String url) throws IOException {
//        // 1.创建Httpclient对象
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        // 2.创建http GET请求
//        HttpGet httpGet = new HttpGet(url);
//        CloseableHttpResponse response = null;
//        // 3.执行请求
//        response = httpclient.execute(httpGet);
//        return response;
//    }


    /**
     *
     * @param url
     * @param entity  为空填写null
     * @param headerMap 为空填写null
     * @return
     * @throws IOException
     */
    public static CloseableHttpResponse get(String url, String entity, HashMap<String, String> headerMap) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet;
        if (entity == null){
            httpGet = new HttpGet(url);
        }else {
            httpGet = new HttpGet(url+"?"+entity);
            System.out.println("url:"+url+"?"+entity);
        }
        if (headerMap != null){
            for (Map.Entry<String, String> entry:headerMap.entrySet()){
                httpGet.addHeader(entry.getKey(),entry.getValue());
            }
        }
        CloseableHttpResponse response = httpClient.execute(httpGet);

        return response;
    }

    /**
     * 创建一个有请求头的get请求
     * @param url
     * @param headerMap
     * @return
     * @throws IOException
     */
//    public static CloseableHttpResponse get(String url, HashMap<String,String> headerMap) throws IOException {
//
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        HttpGet httpGet = new HttpGet(url);
//
//        for (Map.Entry<String, String> entry:headerMap.entrySet()){
//            httpGet.addHeader(entry.getKey(),entry.getValue());
//        }
//        CloseableHttpResponse response = httpClient.execute(httpGet);
//        return response;
//    }

    public static CloseableHttpResponse post(String url, String entityString, HashMap<String,String> headerMap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(entityString));
        for (Map.Entry<String,String> entry:headerMap.entrySet()){
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println("-------------------------");
        return response;
    }
}
