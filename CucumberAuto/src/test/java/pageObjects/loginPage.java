package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy( xpath = "//*[@id=\"mat-input-0\"]") 
	private WebElement txtbx_UserName;

	public void enter_UserName(String name) {
		txtbx_UserName.sendKeys(name);
	}
	
	@FindBy( xpath = "//*[@id=\"mat-input-1\"]") 
	private WebElement txtbx_Password;

	public void enter_Password(String name) {
		txtbx_Password.sendKeys(name);
	}

	@FindBy( xpath = "//button[@type='submit']") 
	private WebElement btn_Login;

	public void click_Login(){
		btn_Login.click();
	}
}
