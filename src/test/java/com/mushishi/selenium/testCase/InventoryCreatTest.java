package com.mushishi.selenium.testCase;

import com.mushishi.selenium.base.DriverBase;
import com.mushishi.selenium.business.CoursePagePro;
import com.mushishi.selenium.business.HomePagePro;
import com.mushishi.selenium.business.InventoryCreatPro;
import com.mushishi.selenium.business.LoginPro;
import com.mushishi.selenium.handle.InventoryCreatHandler;
import com.mushishi.selenium.page.InventoryCreatPage;
import com.mushishi.selenium.util.HandleCookie;
import com.mushishi.selenium.util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.apache.xalan.xsltc.compiler.util.Util.println;

public class InventoryCreatTest extends CaseBase{
    public InventoryCreatPro creatPro;
    public InventoryCreatHandler creatHandler;
    public InventoryCreatPage creatPage;
    public DriverBase driver;
    public InventoryCreatPro icp;
    public ProUtil pro;
    @BeforeClass
    public void beforeClass(){
        this.driver = InitDriver("chrome");
        pro = new ProUtil("loginTest.properties");
        driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPro loginpro = new LoginPro(driver);
        driver.get(pro.getPro("url"));
        loginpro.login("hg01", "123456");
        creatPro= new InventoryCreatPro(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    @AfterClass
//    public void afterClass(){
//        driver.close();
//    }
    @Test
    public void testCreatInventory() throws InterruptedException {
        //登陆之后之后等待10s
        Thread.sleep(10000);
        //刷新页面driver.driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver.driver,60);

        //Thread.sleep(10000);
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("门店库存盘点"))));
//        driver.findElement(By.linkText("门店库存盘点")).click();
//        driver.findElement(By.id("生成盘点单")).click();
        String brand = pro.getPro("Brand");
        String store = pro.getPro("Store");
        String bigclass=pro.getPro("Bigclass");
        String mainer=pro.getPro("mainer");
        String flower=pro.getPro("flower");
        String remark=pro.getPro("remark");
        creatPro.InventoryCreat(brand,bigclass,mainer,flower,remark);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        if(homepagepro.AssertLogin(pro.getPro("yq"))){
//            System.out.println("登陆成功"+username);
//            handcookie.writeCookie();
//        }
    }
//    @AfterClass
//    public void afterClass(){
//        driver.close();
//    }
}
