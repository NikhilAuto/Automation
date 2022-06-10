package StepDefs;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.readExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.preregisteration;

public class tooltipwindow {

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
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("I am at registration page")
	public void i_am_at_registration_page() {
		System.setProperty("webdriver.chrome.driver",prop.getchromeDriverPath());
//		System.setProperty("webdriver.gecko.driver", prop.getmozillaDriverPath());
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		String urlUsed = "https://phptravels.com/demo/";
		driver.get(urlUsed);
		driver.manage().window().maximize();
	}

	@Then("I verify the Firstname Please fill out this field. tooltip")
	public void i_verify_the_firstname_please_fill_out_this_field_tooltip() throws InterruptedException {
		Thread.sleep(1000);
		Set <String> WindowHand = driver.getWindowHandles();
		for (String WindowHand1:WindowHand) {
			driver.switchTo().window(WindowHand1);
			String WindowURLActive = "https://phptravels.org/register.php";
			String CurrentURL = driver.getCurrentUrl();
			System.out.println(CurrentURL);
			if(WindowURLActive.equalsIgnoreCase(CurrentURL)) {
				break;
			}		
		}
		String txt_Firstname1 = ".//*[@id=\"inputFirstName\"]";
		System.out.println("ACTION STARTED");
		Actions actions = new Actions(driver);
		WebElement firstName = driver.findElement(By.xpath(txt_Firstname1));
		actions.moveToElement(firstName).build().perform();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txt_Firstname1)));
		System.out.println("COMPARE ACTUAL");
		String actualTooltip = firstName.getAttribute("title");
		// Assert the tooltip's value is as expected
		System.out.println("Actual Title of Tool Tip" + actualTooltip);
		if (actualTooltip.equals("Please fill out this field.")) {
			System.out.println("Test Case Passed");
		}
	}

	@Then("I verify the Lastname Please fill out this field. tooltip")
	public void i_verify_the_lastname_please_fill_out_this_field_tooltip() throws InterruptedException {

		Thread.sleep(1000);
		String txt_Lastname1 = ".//*[@id=\"inputLastName\"]";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txt_Lastname1)));
		WebElement lastName = driver.findElement(By.xpath(txt_Lastname1));

		String actualTooltip = lastName.getAttribute("title");
		// Assert the tooltip's value is as expected
		System.out.println("Actual Title of Tool Tip" + actualTooltip);
		if (actualTooltip.equals("Please fill out this field.")) {
			System.out.println("Test Case Passed");
		}

		Actions actions = new Actions(driver);

		actions.moveToElement(lastName).perform();

	}

	@When("I click on registration button")
	public void i_click_on_registration_button() {

		String SignupXpath = "//a[contains(text(),'Sign up')]";
//		driver.findElement(By.xpath(SignupXpath)).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignupXpath)));
		// click on the compose button as soon as the "compose" button is visible
		driver.findElement(By.xpath(SignupXpath)).click();
	}

	@Given("I am at toolsqa registration page")
	public void i_am_at_toolsqa_registration_page() {

		System.setProperty("webdriver.chrome.driver", prop.getchromeDriverPath());
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/tool-tips");
		driver.manage().window().maximize();
		System.out.println("demoqa webpage Displayed");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Instantiate Action Class
		Actions actions = new Actions(driver);

		// Retrieve WebElement
		WebElement element = driver.findElement(By.id("toolTipButton"));

		// Use action class to mouse hover
		actions.moveToElement(element).perform();

//		WebElement toolTip = driver.findElement(By.cssSelector("[aria-describedby='buttonToolTip']"));
		WebElement toolTip = driver.findElement(By.xpath(".//*[@aria-describedby='buttonToolTip']"));

		// To get the tool tip text and assert
		String toolTipText = toolTip.getText();
		System.out.println("toolTipText-->" + toolTipText);

		// Verification if tooltip text is matching expected value
		if (toolTipText.equalsIgnoreCase("You hovered over the Button.")) {
			System.out.println("Pass* : Tooltip matching expected value");
		} else {
			System.out.println("Fail : Tooltip NOT matching expected value");
		}

		// Close the main window
		driver.close();

	}

	@Then("I verify the Hover to use tooltip")
	public void i_verify_the_hover_to_use_tooltip() {

	}

}
