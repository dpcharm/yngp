package com.yueniu.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Set;
import java.util.concurrent.TimeUnit;

public class XGZX {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:\\workspace\\yngp\\yngp\\src\\main\\java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
        String parentHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle: windowHandles){
            System.out.println("handle:"+handle);
            driver.switchTo().window(handle);
        }
        driver.switchTo().window(parentHandle);
//        System.out.println("driver.getPageSource():"+driver.getPageSource());
        System.out.println("driver.getCurrentUrl():"+driver.getCurrentUrl());
        System.out.println("driver.getTitle():"+driver.getTitle());
        driver.getTitle();
        driver.findElement(By.xpath("//*[@id=\"s-usersetting-top\"]")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"s-user-setting-menu\"]/div/a[2]")).click();
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie: cookies){
            System.out.println(cookie.getName() + "------" + cookie.getValue());
        }
//        driver.navigate().forward();
        driver.manage().timeouts().implicitlyWait(20000,TimeUnit.SECONDS);
        Thread.sleep(2000);
        driver.quit();

    }

}
