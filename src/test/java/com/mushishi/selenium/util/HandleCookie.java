package com.mushishi.selenium.util;

import java.util.Set;

import org.openqa.selenium.Cookie;

import com.mushishi.selenium.base.DriverBase;

public class HandleCookie {
	public DriverBase driver;
	public ProUtil pro;
	public HandleCookie(DriverBase driver){
		this.driver = driver;
		pro = new ProUtil("cookie.properties");
	}
	public void setCookie(){
		String value = pro.getPro("SESSION");
		Cookie cookie = new Cookie("SESSION",value);
		//Cookie cookie = new Cookie("apsid",value,"imooc.com","/",null);
		driver.setCookie(cookie);
	}
	/**
	 * 获取cookie
	 * */
	public void writeCookie(){
		Set<Cookie> cookies = driver.getCookie();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("SESSION")){
				pro.writePro(cookie.getName(), cookie.getValue());
			}
		}
	}
}
