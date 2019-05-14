package com.mushishi.selenium.handle;

import com.mushishi.selenium.base.DriverBase;
import com.mushishi.selenium.page.InventoryCreatPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryCreatHandler  {
    public DriverBase driver;
    public InventoryCreatPage icp;
    public InventoryCreatHandler(DriverBase driver){
        this.driver = driver;
        icp = new InventoryCreatPage(driver);
    }
    /**
     * 点击门店库存盘点
     * */
    public void clickInventoryButton(){
        icp.click(icp.getInventoryButtonElement());
    }
    /**
     * 点击生成盘点单
     * */
    public void clickCreatButton(){
        icp.click(icp.getCreatButtonElement());
    }
    /**
     * 切换iframe
     * */
    public void switchiframe(){
        icp.swithToiframe(icp.getiframe());
    }
    /**
     * 选择品牌
     * */
    /**
     * 选择品牌
     * */
    public void ChooseBrand(String brand){
        WebElement el=icp.getBrandElement();
        Select selector = new Select(el);
        //选择下拉元素
        selector.selectByVisibleText(brand);

    }
    /**
     * 选择门店1798
     * */
    public void ChooseStore() throws InterruptedException {
        WebElement e=icp.getStoreElement();
        e.click();
        Thread.sleep(3000);
        WebElement e1=icp.getStore();
        e1.click();
    }
    /**
     * 选择大类
     * */
    public void ChooseBigclass(String bigclass) {
        WebElement el=icp.getBigclassElement();
        Select selector = new Select(el);
        //选择下拉元素
        selector.selectByValue(bigclass);
    }
    /**
     * 填写盘点人
     * */
    public void  sendMainer(String mainer){
        icp.getMainpersonElement().sendKeys(mainer);

    }
    /**
     * 填写跟盘人
     * */
    public void  sendFlower(String flower){
        icp.getMainpersonElement().sendKeys(flower);

    }
    /**
     * 填写备注
     * */
    public void  sendRemark(String remark){
        icp.getRemarkElement().sendKeys(remark);

    }
    /**
     * 点击提交按钮
     * */
    public void clickCreat() throws InterruptedException {
        icp.getCreatElement().click();
        //点击确认，点击之前退出iframe
        driver.driver.switchTo().defaultContent();
        Thread.sleep(5000);

        icp.getConfirm().click();
    }
/**
     * 判断是否是登陆页面
     * */
//    public boolean assertLoginPage(){
//        return lp.assertElementIs(lp.getUserElement());
//    }

}
