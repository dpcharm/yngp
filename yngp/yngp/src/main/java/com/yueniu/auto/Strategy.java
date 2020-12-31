package com.yueniu.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Strategy {

    WebDriver driver;
    Login login;
    static ResourceBundle bundle = ResourceBundle.getBundle("url/yngp_backstage", Locale.CHINA);


    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(bundle.getString("LOGIN_URL"));
    }

    /**
     * 创建策略
     */
    public void createStrategy(){

        login = new Login(driver);





    }

}
