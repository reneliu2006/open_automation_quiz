package com.cucu.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import com.cucu.core.BrowserEmulator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;


public class ElementAction {
	private static Logger logger = Logger.getLogger(BrowserEmulator.class);
	
	WebDriver driver;
	public ElementAction(WebDriver driver) {
		this.driver = driver;
	}
	
	AppiumDriver appdriver;
	public ElementAction(AppiumDriver appdriver) {
		this.appdriver = appdriver;
	}
	
	public WebElement getElement(String locator, String type) {
		// 传入查找元素的方法，转为小写，if条件判断通过什么方法查找元素
		type = type.toLowerCase();
		WebElement element;
		if (type.equals("id")) {
			element = this.driver.findElement(By.id(locator));
		} else if (type.equals("name")) {
			element = this.driver.findElement(By.name(locator));
		} else if (type.equals("xpath")) {
			element = this.driver.findElement(By.xpath(locator));
		} else if (type.equals("css")) {
			element = this.driver.findElement(By.cssSelector(locator));
		} else if (type.equals("classname")) {
			element = this.driver.findElement(By.className(locator));
		} else if (type.equals("tagname")) {
			element = this.driver.findElement(By.tagName(locator));
		} else if (type.equals("linktext")) {
			element = this.driver.findElement(By.linkText(locator));
		} else if (type.equals("partiallinktext")) {
			element = this.driver.findElement(By.partialLinkText(locator));
		} else {
			logger.error("方法不存在！");
			return null;
		}
		return element;
	}
	
	public List<WebElement> getElementsList(String locator, String type) {
		// 传入查找元素的方法，转为小写，if条件判断通过什么方法查找元素
		type = type.toLowerCase();
		// 使用集合框架，list接收多个元素，最后进行封装
		List<WebElement> element = new ArrayList<WebElement>();
		if (type.equals("id")) {
			element = this.driver.findElements(By.id(locator));
		} else if (type.equals("name")) {
			element = this.driver.findElements(By.name(locator));
		} else if (type.equals("xpath")) {
			element = this.driver.findElements(By.xpath(locator));
		} else if (type.equals("css")) {
			element = this.driver.findElements(By.cssSelector(locator));
		} else if (type.equals("classname")) {
			element = this.driver.findElements(By.className(locator));
		} else if (type.equals("tagname")) {
			element = this.driver.findElements(By.tagName(locator));
		} else if (type.equals("linktext")) {
			element = this.driver.findElements(By.linkText(locator));
		} else if (type.equals("partiallinktext")) {
			element = this.driver.findElements(By.partialLinkText(locator));
		} else {
			logger.error("方法不存在！");
			return null;
		}
		return element;
	}
	public void getUrl(String url) {
		this.driver.get(url);
	}
	
	public void switchToFrame(int index) {
		this.driver.switchTo().frame(index);
	}
	
	public void srollPage() {
		((JavascriptExecutor) this.driver).executeScript("window.scrollBy(0, 700)"); 
	}

	public void sendKeys(String locator, String type,String value) {
		getElement(locator,type).sendKeys(value);
	}
	
	public void clear(String locator, String type) {
		getElement(locator,type).clear();
	}
	
	public void click(String locator, String type) {
		getElement(locator,type).click();
	}
	
	public void waitD(int t) {
		this.driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
	}
	
	public String getText(String locator, String type) {
		return getElement(locator,type).getText();
	}
	

	public void ScreenShot(String name) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date t = new Date();
		SimpleDateFormat df = new SimpleDateFormat(".yyyy.MM.dd");
        try {
            String savePath = ".\\target\\screenshot\\" + name + df.format(t) + ".png";
            logger.info("ScreenShot savepath" + savePath);
            FileUtils.copyFile(scrFile, new File(savePath));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }

	}
	
	public void alertAccept() {
		this.driver.switchTo().alert().accept();
	}
	
	public void close() {
		this.driver.close();
	}
	
	public WebElement appGetElement(String locator, String type) {
		// 传入查找元素的方法，转为小写，if条件判断通过什么方法查找元素
		type = type.toLowerCase();
		WebElement element;
		if (type.equals("id")) {
			element = this.appdriver.findElement(By.id(locator));
		} else if (type.equals("name")) {
			element = this.appdriver.findElement(By.name(locator));
		} else if (type.equals("xpath")) {
			element = this.appdriver.findElement(By.xpath(locator));
		} else if (type.equals("css")) {
			element = this.appdriver.findElement(By.cssSelector(locator));
		} else if (type.equals("classname")) {
			element = this.appdriver.findElement(By.className(locator));
		} else if (type.equals("tagname")) {
			element = this.appdriver.findElement(By.tagName(locator));
		} else if (type.equals("linktext")) {
			element = this.appdriver.findElement(By.linkText(locator));
		} else if (type.equals("partiallinktext")) {
			element = this.appdriver.findElement(By.partialLinkText(locator));
		} else {
			logger.error("方法不存在！");
			return null;
		}
		return element;
	}
	
	public void appSendKeys(String locator, String type,String value) {
		appGetElement(locator,type).sendKeys(value);
	}
	
	public void appClear(String locator, String type) {
		appGetElement(locator,type).clear();
	}
	
	public void appClick(String locator, String type) {
		appGetElement(locator,type).click();
	}
	
	public String appGetText(String locator, String type) {
		return appGetElement(locator,type).getText();
	}
	
	public void appWaitD() {
		this.appdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void SwipeUp() {
        Dimension size = appdriver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(appdriver).longPress(PointOption.point(width / 2, 100))
                .moveTo(PointOption.point(width / 2, height - 100)).release()
                .perform();
    }

    public void SwipeDown() {
        Dimension size = appdriver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(appdriver)
                .longPress(PointOption.point(width / 2, height - 100))
                .moveTo(PointOption.point(width / 2, 100)).release().perform();
    }
    
	public void appClose() {
		this.appdriver.quit();
	}
	
}
