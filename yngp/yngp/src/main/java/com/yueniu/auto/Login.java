package com.yueniu.auto;

import com.yueniu.common.YNXpath;
import com.yueniu.common.YNXpathEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver;

    By userName = By.xpath(YNXpath.getXpath(YNXpathEnum.LOGIN_USERNAME));
    By passwd = By.xpath(YNXpath.getXpath(YNXpathEnum.LOGIN_PASSWD));
    By loginBtn = By.xpath(YNXpath.getXpath(YNXpathEnum.LOGIN_CLICK));


    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String username){
        driver.findElement(userName).sendKeys(username);
    }

    public void setPasswd (String pwd){
        driver.findElement(passwd).sendKeys(pwd);
    }

    public void LoginClick(){
        driver.findElement(loginBtn).click();
    }

    public void loginToMainPage(String username, String passwd){
        setUserName(username);
        setPasswd(passwd);
        LoginClick();
    }

}
