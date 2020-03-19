package com.cucu.core;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class AppEmulator {
    private static Logger logger = Logger.getLogger(BrowserEmulator.class);

    public AppiumDriver app() throws Exception {
    	AppiumDriver driver;
    	String apkfile = System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "douban_179.apk";
        String platformName = GlobalSettings.platformName;
        String platformVersion = GlobalSettings.platformVersion;
        String deviceName = GlobalSettings.deviceName;
        String appPackage = GlobalSettings.appPackage;
        String appActivity = GlobalSettings.appActivity;
        String url = GlobalSettings.url;

        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("platformName", platformName);
        des.setCapability("platformVersion", platformVersion);
        des.setCapability("deviceName", deviceName);
        des.setCapability("app", apkfile);
        des.setCapability("appPackage", appPackage);
        des.setCapability("appActivity", appActivity);
        des.setCapability("automationName", "UIAutomator2");

        //des.setCapability("unicodeKeyboard", True);//支持中文输入
        //des.setCapability("resetKeyboard", True);//支持中文输入
        des.setCapability("newCommandTimeout", "10");//没有新命令时的超时时间设置
        des.setCapability("nosign", "True");//跳过检查和对应用进行 debug 签名的步骤

        driver = new AndroidDriver(new URL(url), des);//虚拟机默认地址
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
