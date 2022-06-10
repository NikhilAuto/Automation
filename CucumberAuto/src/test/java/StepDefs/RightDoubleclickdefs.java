package StepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;

public class RightDoubleclickdefs {

	WebDriver driver;
	PropFileReader prop = new PropFileReader();

	@Given("I want to test Right Click scenario")
	public void i_want_to_test_right_click_scenario() {

		System.setProperty("webdriver.chrome.driver", prop.getchromeDriverPath());
//		System.setProperty("webdriver.gecko.driver", prop.getmozillaDriverPath());
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();		

		driver.get("https://demoqa.com/buttons");
		System.out.println("demoqa webpage displayed");

		// Maximise browser window
		driver.manage().window().maximize();

		// Instantiate Action Class
		Actions actions = new Actions(driver);

		// Retrieve WebElement to perform right click
		WebElement btnElement = driver.findElement(By.id("rightClickBtn"));

		// Right Click the button to display Context Menu&nbsp;
		actions.contextClick(btnElement).perform();
		System.out.println("Right click Context Menu displayed");

		// Following code is to select item from context menu which gets open up on
		// right click, this differs
		// depending upon your application specific test case:
		// Select and click 'Copy me' i.e. 2nd option in Context menu
		WebElement elementOpen = driver.findElement(By.xpath(".//div[@id='rightclickItem']/div[1]"));
		elementOpen.click();

		// Accept the Alert
		driver.switchTo().alert().accept();
		System.out.println("Right click Alert Accepted");

		// Close the main window
		driver.close();
	}


	@Given("I want to test Double Click scenario")
	public void i_want_to_test_double_click_scenario() {
		
		System.setProperty("webdriver.chrome.driver", prop.getchromeDriverPath());
//		System.setProperty("webdriver.gecko.driver", prop.getmozillaDriverPath());
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();		

		// Launch the URL
		driver.get("https://demoqa.com/buttons");
		System.out.println("Demoqa Web Page Displayed");

		// Maximise browser window
		driver.manage().window().maximize();

		// Instantiate Action Class
		Actions actions = new Actions(driver);

		// Retrieve WebElement to perform double click WebElement
		WebElement btnElement = driver.findElement(By.id("doubleClickBtn"));

		// Double Click the button
		actions.doubleClick(btnElement).perform();

		System.out.println("Button is double clicked");

		// Following code just click on OK button on alert , this differs
		// depending upon application(under test) specific test case
		// Accept the Alert
		driver.switchTo().alert().accept();
		System.out.println("Double click Alert Accepted");

		// Close the main window
		driver.close();
	}

}