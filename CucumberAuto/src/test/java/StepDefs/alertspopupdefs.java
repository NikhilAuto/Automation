package StepDefs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

public class alertspopupdefs {

	WebDriver driver;
	PropFileReader prop = new PropFileReader();

	@Given("I want to test alert using webdriver scenario")
	public void i_want_to_test_alert_using_webdriver_scenario() {

		System.setProperty("webdriver.chrome.driver", prop.getchromeDriverPath());
//		System.setProperty("webdriver.gecko.driver", prop.getmozillaDriverPath());
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();	
		// Alert Message handling
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("53920");
		driver.findElement(By.name("submit")).submit();
		// Switching to Alert
		Alert alert = driver.switchTo().alert();
		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMessage);
//		To Send Text or Type on Alert Box
//		driver.switchTo().alert().sendKeys("Text");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Accepting alert
		alert.accept();
	}


	@Given("I want to test alert using Robot scenario")
	public void i_want_to_test_alert_using_robot_scenario() throws InterruptedException, AWTException {
			
		System.setProperty("webdriver.chrome.driver", prop.getchromeDriverPath());
//		System.setProperty("webdriver.gecko.driver", prop.getmozillaDriverPath());
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		
	      driver.get("https://app.campusorbit.com/auth/login"); // sample url	
	           driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).click();	
	           Robot robot = new Robot();  // Robot class throws AWT Exception	
	           Thread.sleep(2000); // Thread.sleep throws InterruptedException	
	           robot.keyPress(KeyEvent.VK_DOWN);  // press arrow down key of keyboard to navigate and select Save radio button	
	           Thread.sleep(2000);  // sleep has only been used to showcase each event separately	
	           robot.keyPress(KeyEvent.VK_TAB);	
	           Thread.sleep(2000);	
	           robot.keyPress(KeyEvent.VK_TAB);	
	           Thread.sleep(2000);	
	           robot.keyPress(KeyEvent.VK_TAB);	
	           Thread.sleep(2000);	
	           robot.keyPress(KeyEvent.VK_ENTER);	
	       // press enter key of keyboard to perform above selected action	
	     }	 
	
}
