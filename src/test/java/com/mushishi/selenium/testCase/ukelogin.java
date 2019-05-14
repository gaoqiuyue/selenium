package com.mushishi.selenium.testCase;

import com.mushishi.selenium.base.DriverBase;
import com.mushishi.selenium.business.LoginPro;
import com.mushishi.selenium.handle.loginPageHandle;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ukelogin extends CaseBase{
    public DriverBase driver;
    public loginPageHandle  lph;
    public DriverBase driverBase;
    public LoginPro lp;
    @Test
    public void ukelogin(){
        this.driver = InitDriver("chrome");
        driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://10.10.0.97:8080/uke-admin/");
        lp.login("hg01","123456");
        lph.clickLoginButton();
    }
}
