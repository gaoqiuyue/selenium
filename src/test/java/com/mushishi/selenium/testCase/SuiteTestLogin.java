package com.mushishi.selenium.testCase;

import com.mushishi.selenium.base.DriverBase;
import com.mushishi.selenium.business.HomePagePro;
import com.mushishi.selenium.business.LoginPro;
import com.mushishi.selenium.util.HandleCookie;
import com.mushishi.selenium.util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SuiteTestLogin extends CaseBase{
	public DriverBase driver;
	public LoginPro loginpro;
	public HomePagePro homepagepro;
	public ProUtil pro;
	public HandleCookie handcookie;
	
	@BeforeClass
	public void beforeClass(){
		this.driver = InitDriver("chrome");
		pro = new ProUtil("loginTest.properties");
		driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpro = new LoginPro(driver);
		handcookie = new HandleCookie(driver);
		homepagepro = new HomePagePro(driver);
		driver.get(pro.getPro("url"));
	}
	@Test
	public void testLogin() throws InterruptedException {
		String username = pro.getPro("username");
		String password = pro.getPro("passwd");
		loginpro.login(username, password);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("门店库存盘点")).click();
		driver.findElement(By.id("生成盘点单")).click();
		String handlebefore=driver.driver.getWindowHandle();
		System.out.println(handlebefore);
		//切换进iframe
		driver.driver.switchTo().frame(driver.findElement(By.className("iframeClass")));
		driver.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.findElement(By.id("brand")).isDisplayed();
		driver.findElement(By.xpath("//select[@id='brand']")).click();
		new Select(driver.findElement(By.id("brand"))).selectByVisibleText("KISSCAT");
		//System.out.println(.isDisplayed());

		driver.findElement(By.id("select2-shopNo-container")).click();
        driver.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.className("select2-results__options")).click();
		driver.findElement(By.id("bigClass")).click();
		new Select(driver.findElement(By.id("bigClass"))).selectByVisibleText("女鞋");
		driver.findElement(By.id("bigClass")).click();
        driver.findElement(By.xpath("//button")).click();
        //System.out.println(driver.findElement(By.className("layui-layer-content")).getText());
        driver.driver.switchTo().defaultContent();
       driver.findElement(By.className("layui-layer-btn0")).click();
       //Thread.sleep(3000);
       System.out.println(driver.findElement(By.className("layui-layer-content")).getText());
        driver.driver.switchTo().frame(driver.findElement(By.className("iframeClass")));
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.className("layui-layer-content")).getText());

		handcookie.writeCookie();
		if(homepagepro.AssertLogin(pro.getPro("yq"))){
			System.out.println("登陆成功"+username);
			handcookie.writeCookie();
		}

	}

}
//	@AfterClass
//	public void afterClass(){
//		driver.close();
//	}

