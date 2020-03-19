package cn.ianzhang.automation;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.cucu.action.ElementAction;
import com.cucu.core.BrowserEmulator;
import com.cucu.core.GetCommon;

public class SearchBingTest {
	private static Logger logger = Logger.getLogger(BrowserEmulator.class);
	
	BrowserEmulator be = new BrowserEmulator();
    GetCommon domain = new GetCommon();
    ElementAction ea;
	
	@BeforeClass
    public void setUp()
    {
		WebDriver driver = be.Browser();
		ea = new ElementAction(driver);
    }
	
	@Test(description="获取搜索bing后网页内容")
	public void searchBing() throws InterruptedException {
//        driver.get("http://www.ianzhang.cn/bing/");
//        Thread.sleep(3000);
//        driver.switchTo().alert().accept();
//        Thread.sleep(3000);
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame(0);
		
		ea.getUrl("https://cn.bing.com/");
		ea.waitD(3);
		ea.sendKeys("sb_form_q", "id", "bing");
		ea.click("sb_form_q", "id");
		ea.click("sb_form_go", "id");
        List<String> list = new ArrayList<String>();
        logger.info("结果列表:");
        for(WebElement link : ea.getElementsList("//h2/a", "xpath")){
            String href = link.getAttribute("href");
            String txt = link.getText();
            list.add(href);
            logger.info(href + "-->" + txt);
        }
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (String t : list) {
            String temp = domain.getdomain(t);
            Integer count = (Integer) map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        logger.info("结果统计:");
        for(String key : map.keySet()){
            Integer value = map.get(key);
            logger.info(key + "-->" +value);
        }

    }

    @AfterClass
    public void tearDown()
    {
        ea.close();
    }

}
