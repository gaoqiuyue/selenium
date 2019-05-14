package com.mushishi.selenium.business;

import com.mushishi.selenium.base.DriverBase;
import com.mushishi.selenium.handle.InventoryCreatHandler;
import com.mushishi.selenium.handle.loginPageHandle;
import com.mushishi.selenium.page.InventoryCreatPage;
import org.openqa.selenium.By;

public class InventoryCreatPro {
    public InventoryCreatHandler ich;
    public InventoryCreatPage icpage;
    public DriverBase driver;
    public InventoryCreatPro(DriverBase driver){
        this.driver = driver;
        ich = new InventoryCreatHandler(driver);
    }
    public void InventoryCreat(String brand,String bigclass,String mainer,String flower,String remarks) throws InterruptedException {
//        if(ich.assertLoginPage()){
            ich.clickInventoryButton();
            ich.clickCreatButton();
            ich.switchiframe();
            ich.ChooseBrand(brand);
            Thread.sleep(2000);
            ich.ChooseStore();
            Thread.sleep(2000);
            ich.ChooseBigclass(bigclass);
            ich.sendMainer(mainer);
            ich.sendFlower(flower);
            ich.sendRemark(remarks);
            ich.clickCreat();
            ich.switchiframe();
            Thread.sleep(3000);
            //打印弹框文字内容
            System.out.println(driver.findElement(By.className("layui-layer-content")).getText());
            //截屏

            //lph.clickAutoSignin();
//        }else{
//            System.out.println("页面不存在或者状态不正确。");
//        }
    }
}
