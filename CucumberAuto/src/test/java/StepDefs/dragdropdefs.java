package StepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import pageObjects.homePage;

public class dragdropdefs {

	WebDriver driver;
	PropFileReader prop = new PropFileReader();
	
	@Given("I want to test drag and drop scenario")
	public void i_want_to_test_drag_and_drop_scenario() {

		System.setProperty("webdriver.chrome.driver",prop.getchromeDriverPath());
//		System.setProperty("webdriver.gecko.driver", prop.getmozillaDriverPath());
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
	 
	String URL = "https://demoqa.com/droppable/";
	 
	driver.get(URL);
	 
	// It is always advisable to Maximize the window before performing DragNDrop action		 
	driver.manage().window().maximize();
	 
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	
	//Actions class method to drag and drop		
	Actions builder = new Actions(driver);
	 
	WebElement from = driver.findElement(By.id("draggable"));
	 
	WebElement to = driver.findElement(By.id("droppable"));	 
	//Perform drag and drop
	builder.dragAndDrop(from, to).perform();
	
	//verify text changed in to 'Drop here' box 
	String textTo = to.getText();

	if(textTo.equals("Dropped!")) {
		System.out.println("PASS: Source is dropped to target as expected");
	}else {
		System.out.println("FAIL: Source couldn't be dropped to target as expected");
	}

	driver.close();
}	
		
}