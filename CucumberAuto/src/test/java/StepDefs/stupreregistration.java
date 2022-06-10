package StepDefs;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utility.readExcel;
import Utility.screenPrint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.*;

public class stupreregistration {
	
	loginPage login;
	WebDriver driver;
	homePage home = new homePage(driver);
	PropFileReader prop = new PropFileReader();
	private static Logger log = LogManager.getLogger(loginDefs.class);
	String ExcelFilepath = "C:\\Users\\Nikhil\\Desktop\\Automation";
	String ExcelFilename = "CucumberExcelAuto.xlsx";
	String ExcelSheetname = "Sheet1";
	readExcel getExcelData = new readExcel();
	preregisteration prereg;
	JavascriptExecutor js = (JavascriptExecutor)driver;
		
//	ChromeOptions options = new ChromeOptions(); 
//	options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
//	driver = new ChromeDriver(options); 
	
	@Given("user is on pre-registration page")
	public void user_is_on_pre_registration_page() {
		System.out.println("INSIDE STEP 1");
		System.setProperty("webdriver.chrome.driver",prop.getchromeDriverPath());
		driver = new ChromeDriver(); 
		driver.get(prop.getTestURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screenPrint.takeScreenshotandStore(driver);
		driver.manage().timeouts().implicitlyWait(prop.getImplicitlyWait(), TimeUnit.SECONDS);
	}

	@When("user enters firstname as {string}")
	public void user_enters_firstname_as(String textEnter) {
	    // Write code here that turns the phrase above into concrete actions
		textEnter = "NIKHILAUTO2";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.xpath(".//*[@id=\"mat-input-2\"]")).sendKeys(textEnter);;
		prereg = new preregisteration(driver);
		prereg.txtbx_firstname.sendKeys("FNAME");
		
//		WebElement element = driver.findElement(By.xpath(".//*[@id=\"mat-input-2\"]"));
//		 JavascriptExecutor jse = (JavascriptExecutor)driver;
//		 jse.executeScript("arguments[0].value='enter the value here';", element);		
	}
	
	@When("user enters middlename as {string}")
	public void user_enters_middlename_as(String textEnter) {
	    // Write code here that turns the phrase above into concrete actions
		textEnter = "NIKHILAUTO3";
		driver.findElement(By.xpath(".//*[@id=\"mat-input-3\"]")).sendKeys(textEnter);;
//		prereg.txtbx_firstname.sendKeys(textEnter);
	}
	
	@When("user enters lastname as {string}")
	public void user_enters_lastname_as(String textEnter) {
	    // Write code here that turns the phrase above into concrete actions
		textEnter = "NIKHILAUTO4";
		driver.findElement(By.xpath(".//*[@id=\"mat-input-4\"]")).sendKeys(textEnter);;
//		prereg.txtbx_firstname.sendKeys(textEnter);
	}
	
	@When("user enters dob as {string}")
	public void user_enters_dob_as(String textEnter) {
	    // Write code here that turns the phrase above into concrete actions
		textEnter = "NIKHILAUTO5";
		driver.findElement(By.xpath(".//*[@id=\"mat-input-5\"]")).sendKeys(textEnter);;
//		prereg.txtbx_firstname.sendKeys(textEnter);
	}
	
	@When("user enters emailid as {string}")
	public void user_enters_emailid_as(String textEnter) {
	    // Write code here that turns the phrase above into concrete actions
		textEnter = "NIKHILAUTO6";
		driver.findElement(By.xpath(".//*[@id=\"mat-input-6\"]")).sendKeys(textEnter);;
//		prereg.txtbx_firstname.sendKeys(textEnter);
	}
	
	@When("user enters mobile as {string}")
	public void user_enters_mobile_as(String textEnter) {
	    // Write code here that turns the phrase above into concrete actions
		textEnter = "NIKHILAUTO7";
		driver.findElement(By.xpath(".//*[@id=\"mat-input-7\"]")).sendKeys(textEnter);;
//		prereg.txtbx_firstname.sendKeys(textEnter);
	}
	
	@When("user selects {string}")
	public void user_selects(String optionSelect) {
	    // Write code here that turns the phrase above into concrete actions  
}

}
