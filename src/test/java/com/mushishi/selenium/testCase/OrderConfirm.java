package com.mushishi.selenium.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mushishi.selenium.base.DriverBase;
import com.mushishi.selenium.business.CoursePagePro;
import com.mushishi.selenium.util.HandleCookie;

import java.util.concurrent.TimeUnit;

public class OrderConfirm {

    @Test
   public void OrderConfirm(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\Program\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.get("http://172.16.38.199:9021/sso-admin/login?service=http://omni-pressure.topscore.com.cn:9020/task-admin/cas");
//       driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
//       driver.findElement(By.id("username")).clear();
//       driver.findElement(By.id("username")).sendKeys("o2m1");
//       driver.findElement(By.id("password")).clear();
//       driver.findElement(By.id("password")).sendKeys("tch*2016");
//        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);


//       driver.findElement(By.xpath("//*[@id=\"fm1\"]/section[4]/input[4]")).click();
        //订单确认
        driver.get("http://omni-pressure.topscore.com.cn:9026/order-admin/");
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
        driver.switchTo().frame("westf");
        driver.findElement(By.linkText("待处理订单")).click();


   }
}
