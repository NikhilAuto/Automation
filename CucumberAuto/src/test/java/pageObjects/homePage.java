package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	WebDriver driver;//= new ChromeDriver();

	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy( xpath = "//span[@class='logo-name']") 
	private WebElement img_CampusOrbit;

	public void verify_img_CampusOrbit() {
		System.out.println("ENTER VERIFY IMG METHOD");

		//		img_CampusOrbit.isDisplayed();
		// Javascript executor to check image
		Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", img_CampusOrbit);

		//verify if status is true
		if (p) {
			System.out.println("Logo present");
		} else {
			System.out.println("Logo not present");
		}
	}

}
