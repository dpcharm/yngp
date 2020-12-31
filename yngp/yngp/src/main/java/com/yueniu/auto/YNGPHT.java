package com.yueniu.auto;

import com.yueniu.common.YNXpath;
import com.yueniu.common.YNXpathEnum;
import com.yueniu.utils.YNAutoUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class YNGPHT {

    static WebDriver driver;
    ResourceBundle bundle;
    static String strategyName;

    @BeforeClass
    public static void browserOpen() {
        System.setProperty("webdriver.chrome.driver", "D:\\workspace\\yngp\\yngp\\src\\main\\java\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("BeforeClass加载完毕");
    }

    @Test(priority = 0)
    public void login() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("url/yngp_backstage", Locale.CHINA);
        String login_url = resourceBundle.getString("LOGIN_URL");
        //打开登录界面
        driver.get(login_url);
        driver.manage().window().maximize();
        //输入用户名密码，点击登录 进入系统
        driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.LOGIN_USERNAME))).sendKeys("123123123");
        driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.LOGIN_PASSWD))).sendKeys("123123");
        driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.LOGIN_CLICK))).click();
        //实际的url
        String actualCurrentUrl = driver.getCurrentUrl();
        //期望的url
        String expectCurrentUrl = YNXpath.getXpath(YNXpathEnum.MAIN_URL);
        Assert.assertEquals(actualCurrentUrl, expectCurrentUrl, "登录失败，未进入到主页面");
        System.out.println("登陆成功");
    }

    @Test(priority = 1)
    public void createStrategy() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //点击父菜单显示下拉列表，点击子菜单
        try {
            driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_PARENT))).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY))).click();
//            System.out.println("查找新增策略");
        } catch (Exception e) {
            System.out.println("不存在此元素");
        }

        //点击新增策略按钮
        try {
            driver.switchTo().frame("contentFrame");
            System.out.println("查找新增按钮");
            driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_ADD_BTN))).click();
        } catch (Exception e) {
            System.out.println("未找到新增按钮");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //输入自定义的策略名称
        strategyName = YNAutoUtils.strategyNameGenerate();
        driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_NAME))).sendKeys(strategyName);
        List<WebElement> strategyNameElements = driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_LABEL))).findElements(By.className(YNXpath.getXpath(YNXpathEnum.STRATEGY_LABEL_CHECKBOX_CLASSNAME)));
        int size = strategyNameElements.size();
//        System.out.println("size:" + size);
        //根据策略标签的个数，随机生成范围内两个随机数，并勾选。
        Random random = new Random();
        for (int i = 0; i <= 1; i++) {
            int s = random.nextInt(size) % (size + 1);
            strategyNameElements.get(s).click();
        }

        //选择策略类型  免费/VIP
        driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_TYPE))).click();
        //生成1-2随机数，如果为1，则创建免费策略，如果为2，则创建VIP策略
        Random random2 = new Random();
        int s = random2.nextInt(2);

        if (s == 0) {
            driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_TYPE_FREE))).click();
//            System.out.println("生成的i的值为0");
        } else {
            driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_TYPE_VIP))).click();
//            System.out.println("生成的i的值为1");
        }
        driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_LOGIC))).sendKeys("策略逻辑：" + strategyName);
        driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_STYLE))).sendKeys("策略风格：" + strategyName);
        driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_SUBMIT))).click();
    }

    /**
     * 给策略添加股票
     */
    @Test(priority = 2)
    public void addSharesToStrategy() throws InterruptedException {
        //1、根据createStrategy方法创建的策略名称，找到列表中的策略
        driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_PARENT))).click();
        driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY))).click();
        driver.switchTo().frame("contentFrame");


        strategyName = "策略505782";

        List<WebElement> pageElements = driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.PAGE_NUMBER_PARENT))).findElements(By.tagName("li"));

        System.out.println("pageElements:"+pageElements);

        for (WebElement pageElement : pageElements) {
            pageElement.click();
            System.out.println("pageElement.getText():"+pageElement.getText());

            List<WebElement> cells = driver.findElements(By.className("el-table__row"));
            for (WebElement cell : cells) {
//                System.out.println(cell.findElement(By.className("el-table_1_column_2")).getText());
                String myStrategyName = cell.findElement(By.className("el-table_1_column_2")).getText();
                //如果找到的策略名称和创建的策略名称一致，则点击该策略cell的详情，进行添加股票
                if (strategyName.equals(myStrategyName)) {
                    System.out.println("找到了与创建名称一致的股票");
                    cell.findElement(By.className("el-table_1_column_11")).findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.STRATEGY_DETAILS))).click();
                    Thread.sleep(1000);
                    //1.找到创建的策略之后，点击新增策略
                    driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.SHARES_ADD))).click();
                    //2.随机生成0-9的数字，填写到股票搜索框中
                    Random random = new Random();
                    int randomNum = random.nextInt(10);
                    String shareIndex = String.valueOf(randomNum);
                    driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.SHARES_SEARCH))).sendKeys(shareIndex);
                    //3.根据生成的下拉列表，随机选择一个股票
                    List<WebElement> results = driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.SHARES_LIST))).findElements(By.className("result"));
                    int i = random.nextInt(results.size());
                    //*[@id="stockList"]/div[3]/div/div[2]/form/div[1]/div/div[2]/div[1]
                    //*[@id="stockList"]/div[3]/div/div[2]/form/div[1]/div/div[2]/div[2]
                    driver.findElement(By.xpath(YNXpath.getXpath(YNXpathEnum.SHARES_RANDOM_SELECT))).click();

                    Thread.sleep(5000);

                    break;
                }
            }

        }


    }


    /**
     * 添加策略产品
     */
    @Test(priority = 3)
    public void addStrategyProduct() {
        System.out.println("addStrategyProduct");
    }

    @AfterClass
    public void browserClosed() throws InterruptedException {

        Thread.sleep(5000);
        System.out.println("退出自动化测试进程");
        driver.quit();
    }


}
