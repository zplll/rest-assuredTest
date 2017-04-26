package webTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.*;


/**
 * Created by zipon on 2017/4/18.
 */
public class WebTest01 {

    String configUrl = "http://indiawmoperation.test.uae.uc.cn/";
    String aliuser = "wb-zp280017";
    String alipw = "Zipon789?";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "marionette";
//        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","D:\\driver\\geckodriver.exe");
    }

    @Test
    public void login(){

        //open("http://www.baidu.com");
        open(configUrl);
        $("#loginAccountInput").sendKeys(aliuser);
        $("#loginPassword").sendKeys(alipw);
        $(".submit-button").click();
        $(By.xpath("//img[@role='presentation']")).waitUntil(Condition.exist,10000);
    }
    @Title("创建征文活动")
    @Description("创建征文活动，有效期为创建的一刻")
    @Test(dependsOnMethods = "login")
    public void createEssay(){
        $(By.xpath("//span[contains(.,'Operation Manage')]")).click();
        $(By.xpath("//a[@href='essay']")).click();
        $(By.xpath("//button[contains(.,'Create Essay')]")).click();
        //印度比北京小2.5个小时900000ms  印尼比北京小1个小时 3600000
        String activityName = "essayName"+System.currentTimeMillis();
        $("#activityName").sendKeys(activityName);
        $$(By.xpath("//input[@placeholder='Select date']")).get(0).click();
        $(By.xpath("//td[@title='2017-4-24']")).click();
        $(By.xpath("//a[contains(.,'Ok')]")).click();
        $$(By.xpath("//input[@placeholder='Select date']")).get(1).click();
        $(By.xpath("//td[@title='2017-4-24']")).click();
        $(By.xpath("//a[contains(.,'Ok')]")).click();
        $(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-lg']")).click();
        sleep(10000);
    }
    @Test
    public void test(){
        long sss= System.currentTimeMillis();
        //long ss1= 1493025000000L;
        Date dds = new Date(1493025000000L+1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(System.currentTimeMillis()+"------"+sdf.format(dds));
    }
}
