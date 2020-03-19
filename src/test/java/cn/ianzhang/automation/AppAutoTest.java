package cn.ianzhang.automation;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.cucu.action.ElementAction;
import com.cucu.core.AppEmulator;


public class AppAutoTest {
    AppEmulator emulator = new AppEmulator();
    ElementAction  ea;
    
    @BeforeClass
    public void setUp() throws Exception
    {
    	AppiumDriver appdriver = emulator.app();
        ea = new ElementAction(appdriver);
    }

    @Test(description="使用appnium进行操作")
    public void appAuto() throws InterruptedException {
    	ea.appClick("search_hint", "id");
    	ea.appWaitD();
    	ea.appClick("search", "id");
    	ea.appClear("search", "id");
    	ea.appSendKeys("search", "id","新型");
    	ea.appClick("cover", "id");
    	ea.appWaitD();
    	ea.SwipeDown();
    	String text = ea.appGetText("toolbar_title","id");
    	Assert.assertEquals(text, "新型冠状病毒网恋组");
    	
    }
    
    @AfterClass
    public void tearDown() throws Exception {
    	ea.appClose();
    }
}
