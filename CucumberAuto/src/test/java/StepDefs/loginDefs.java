package StepDefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.loginPage;
import pageObjects.homePage;
import StepDefs.PropFileReader;
import Utility.readExcel;

public class loginDefs {

	loginPage login;
	WebDriver driver;
	homePage home = new homePage(driver);
	PropFileReader prop = new PropFileReader();
	private static Logger log = LogManager.getLogger(loginDefs.class);
	String ExcelFilepath = "C:\\Users\\Nikhil\\Desktop\\Automation";
	String ExcelFilename = "CucumberExcelAuto.xlsx";
	String ExcelSheetname = "Sheet1";
	readExcel getExcelData = new readExcel();


	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("INSIDE STEP 1");
		System.setProperty("webdriver.chrome.driver",prop.getchromeDriverPath());
		log.debug("DEBUG INSIDE STEP 1");
		log.debug("DEBUG INSIDE STEP 1");
		log.error("TESTING LOG ERROR");

		driver = new ChromeDriver(); 
		String baseUrl = "https://app.campusorbit.com/auth/login";
//		driver.get(prop.getTestURL());
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(prop.getImplicitlyWait(), TimeUnit.SECONDS);
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String userName, String passWord) {
		System.out.println("INSIDE STEP 2");
		login = new loginPage(driver);
		login.enter_UserName(userName);
		log.debug("DEBUG INSIDE STEP 2" + userName);
		login.enter_Password(passWord);
		log.debug("DEBUG INSIDE STEP 2" + passWord);
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		System.out.println("INSIDE STEP 3");
		login.click_Login();
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() throws IOException {
		System.out.println("INSIDE STEP 4");
//		home.verify_img_CampusOrbit();		
		driver.close();
		getExcelData.readExcelData(ExcelFilepath, ExcelFilename, ExcelSheetname);	
	}
}
