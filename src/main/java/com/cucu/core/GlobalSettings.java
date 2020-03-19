package com.cucu.core;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class GlobalSettings
{
    private static Logger logger = Logger.getLogger(GlobalSettings.class);
    public static Properties prop = getProperties();
    public static int browserType = Integer.parseInt(prop.getProperty("BrowserType"));
    public static String platformName = prop.getProperty("platformName");
    public static String platformVersion = prop.getProperty("platformVersion");
    public static String udid = prop.getProperty("udid");
    public static String deviceName = prop.getProperty("deviceName");
    public static String appPackage = prop.getProperty("appPackage");
    public static String appActivity = prop.getProperty("appActivity");
    public static String url = prop.getProperty("url");

    public static String getProperty(String p)
    {
        return prop.getProperty(p);
    }

    public static Properties getProperties()
    {
        String filePath = System.getProperty("user.dir") + File.separator + "prop.properties";
        Properties prop = new Properties();
        try
        {
            FileInputStream fis = new FileInputStream(filePath);
            prop.load(fis);
            fis.close();
        }
        catch (Exception e)
        {
            logger.error(filePath + "...prop.properties is not exist", e);
        }
        return prop;
    }
}
