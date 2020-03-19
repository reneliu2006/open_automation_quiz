package steps;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.cucu.core.BrowserEmulator;
import com.cucu.core.GetCommon;
import com.cucu.action.ElementAction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class UIFillTableTest {
	GetCommon domain = new GetCommon();
	BrowserEmulator be = new BrowserEmulator();
	ElementAction ea;
	String date = domain.getDate();
	WebDriver driver = be.Browser();

    @BeforeClass
    public void setUp()
    {
        BrowserEmulator be = new BrowserEmulator();
		driver = be.Browser();
    }

    @When("^open the url$")
	public void openURL() throws InterruptedException{
		ea = new ElementAction(driver);
		ea.getUrl("https://templates.jinshuju.net/detail/Dv9JPD");
		ea.waitD(3);
		ea.switchToFrame(0);
		ea.srollPage();
		ea.waitD(3);
		ea.click("//label[2]//div[@class='choice-description']", "xpath");
    }
		
		
	@Then("^save screenShot and click step 2$")
	public void clickNextStep() throws InterruptedException{
		ea.ScreenShot("page1");
		ea.waitD(3);
		ea.click("下一页", "linkText");
		ea.waitD(3);
	}
	
	@Given("^second page input applicant (.*?)$")
	public void fillStepSecondApplicant(String applicant) throws InterruptedException{
		ea.srollPage();
		ea.sendKeys("entry_field_18", "id", date);
		ea.click("entry_field_19", "id");
		ea.sendKeys("entry_field_19", "id", applicant);
	}
	
	@Given("^second page input contact (.*?)$")
	public void fillStepSecondContact(String contact) throws InterruptedException{
		ea.sendKeys("entry_field_20", "id", contact);
		ea.waitD(3);
	}
	
	@Then("^save screenShot and click step 3$")
	public void clickStep3() throws InterruptedException{
		ea.ScreenShot("page2");
		ea.waitD(3);
		ea.click("下一页", "linkText");
		ea.waitD(3);
	}
	
	@Given("^third page input unit (.*?)$")
	public void fillStepThirdStepUnit(String unit) throws InterruptedException{
		ea.sendKeys("entry_field_23", "id", unit);
	}
	
	@Given("^third page input number (.*?)$")
	public void fillStepThirdStepNumber(String number) throws InterruptedException{
		ea.sendKeys("entry_field_24", "id", number);
	}
	
	@Given("^third page input employees (.*?)$")
	public void fillStepThirdStepEmployees(String employees) throws InterruptedException{
		ea.sendKeys("entry_field_25", "id", date);
		ea.click("entry_field_26", "id");
		ea.sendKeys("entry_field_26", "id", employees);
	}

	@Given("^third page input header (.*?)$")
	public void fillStepThirdStepHeader(String header) throws InterruptedException{
		ea.sendKeys("entry_field_27", "id", header);
	}
	
	@Given("^third page input contact1 (.*?)$")
	public void fillStepThirdStepContact(String contact1) throws InterruptedException{
		ea.sendKeys("entry_field_28", "id", contact1);
	}
	
	@Given("^third page input plan (.*?)$")
	public void fillStepThirdStepPlan(String plan) throws InterruptedException{
		ea.sendKeys("entry_field_29", "id", plan);
		ea.waitD(3);
	}
	
	@Then("^commit and save success screenShot$")
	public void commit() throws InterruptedException{
		ea.click("//input[@type='submit']", "xpath");
		ea.waitD(3);
		ea.getText("//div[@class='message']","xpath");
		ea.ScreenShot("page3");
		ea.close();
	}

    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}
