package com.mushishi.selenium.page;

import com.mushishi.selenium.base.DriverBase;
import com.mushishi.selenium.util.getByLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryCreatPage extends BasePage{


    public InventoryCreatPage(DriverBase driver) {
        super(driver);
    }
    /**
     * 获取门店库存盘点单按钮
     * */
    public WebElement getInventoryButtonElement(){
        return element(getByLocator.getLocator("inventory"));
    }
    /**
     * 获取生成盘点单按钮
     * */
    public WebElement getCreatButtonElement(){
        return element(getByLocator.getLocator("inventorycreat"));
    }
    /**
     * 获取需要切换到iframe
     * */
    public WebElement getiframe(){
        return element(getByLocator.getLocator("iframecreat"));

}
    /**
     * 获取品牌选择框
     * */
    public WebElement getBrandElement(){
        return element(getByLocator.getLocator("brand"));
    }

    /**
     *门店选择框
     * */
    public WebElement getStoreElement(){
        return element(getByLocator.getLocator("store"));
    }
    /**
     *门店选择项1798店铺
     * */
    public WebElement getStore(){
        return element(getByLocator.getLocator("store1798"));
    }
    /**
     * 获取大类
     * */
    public WebElement getBigclassElement(){
        return element(getByLocator.getLocator("bigclass"));
    }
    /**
     * 获取盘点人
     * */
    public WebElement getMainpersonElement(){
        return element(getByLocator.getLocator("mainperson"));
    }
    /**
     * 获取跟盘人
     * */
    public WebElement getFlowerElement(){
        return element(getByLocator.getLocator("flower"));
    }
    /**
     * 获取备注
     * */
        public WebElement getRemarkElement(){
        return element(getByLocator.getLocator("remark"));
    }
    /**
     * 获取提交按钮
     * */
    public WebElement getCreatElement(){
        return element(getByLocator.getLocator("creatbutton"));
    }
    /**
     * 获取确认按钮
     * */
    public WebElement getConfirm(){
        return element(getByLocator.getLocator("confirm"));
    }

}
