package StepDefs;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;

public class testngDemo {

	static loginPage login;
	static WebDriver driver;
	static String passWord = "Nikhil@99";
	static String userName = "nikhilatdalmia@gmail.com";
	static PropFileReader prop = new PropFileReader();
	
	@BeforeTest
	public static void entry() {

		homePage home = new homePage(driver);
		System.out.println("INSIDE STEP 1");
		System.setProperty("webdriver.gecko.driver", prop.getmozillaDriverPath());
		driver = new FirefoxDriver();  
//		String baseUrl = "http://localhost:4200/";
		driver.get(prop.getTestURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(prop.getImplicitlyWait(), TimeUnit.SECONDS);
	}

	@Test
	public static void maintest() {

		System.out.println("INSIDE STEP 2");
		login = new loginPage(driver);
		login.enter_UserName(userName);
		login.enter_Password(passWord);
		System.out.println("INSIDE STEP 3");
		login.click_Login();
	}

	@AfterTest
	public static void out() {
		System.out.println("INSIDE STEP 4");
//		home.verify_img_CampusOrbit();		
		driver.close();
//		driver.quit();
	}

}
