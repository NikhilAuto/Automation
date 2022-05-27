package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class preregisteration {

	private WebDriver driver;//= new ChromeDriver();

	public preregisteration(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy( xpath = ".//*[@id=\"mat-input-2\"]")
	public WebElement txtbx_firstname;
	
	public By txtbx1_firstname = By.xpath(".//*[@id=\"mat-input-2\"]");
	

	@FindBy( xpath = "//*[@id=\"mat-input-5\"]") 
	private WebElement txtbx_lastname;
	
	@FindBy( xpath = "//*[@id=\"mat-input-6\"]") 
	private WebElement txtbx_middlename;
	
	@FindBy( xpath = "//*[@id=\"mat-input-7\"]") 
	private WebElement txtbx_dob;
	
	@FindBy( xpath = "//*[@id=\"mat-input-8\"]") 
	public WebElement txtbx_email;
	
	@FindBy( xpath = "//*[@id=\"mat-input-9\"]") 
	public WebElement txtbx_mob;
	
	@FindBy( xpath = "//*[@id=\"mat-select-value-1\"]") 
	public WebElement slct_gender;
	
	@FindBy( xpath = "//*[@id=\"mat-input-10\"]") 
	public WebElement txtbx_rollno;
	
	@FindBy( xpath = "//*[@id=\"mat-select-value-3\"]") 
	public WebElement slct_stubranch;
	
	@FindBy( xpath = "//*[@id=\"mat-select-value-5\"]") 
	public WebElement slct_stuyear;
	
	@FindBy( xpath = "//*[@id=\"mat-select-value-7\"]") 
	public WebElement slct_stusem;
	
	@FindBy( xpath = "//*[@id=\"mat-select-value-9\"]") 
	public WebElement slct_studiv;
	
	}
