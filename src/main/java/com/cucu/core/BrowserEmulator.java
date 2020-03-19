package com.cucu.core;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserEmulator
{
    private static Logger logger = Logger.getLogger(BrowserEmulator.class);

    public WebDriver Browser()
    {
        int browserType = GlobalSettings.browserType;
        WebDriver driver = setupBrowser(browserType);
        logger.info("Started BrowserEmulator");
        return driver;
    }

    private WebDriver setupBrowser(int type)
    {
    	WebDriver driver = null;
        if (type == 1)
        {
            logger.info("Using Chrome");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (type == 2)
        {
            logger.info("Using ie");
            System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else if (type == 3)
        {
            logger.info("Using Chrome Headless");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[] { "--headless" });
            driver = new ChromeDriver(options);
        }
        else
        {
            logger.error("Incorrect browser type");
        }
        return driver;
    }
}
