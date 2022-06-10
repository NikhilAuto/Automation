package testNGauto;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BasicTest {
  @Test
  public void f() {
	  System.out.println("Gmail Logged in successfully");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Launch the Browser");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Log out of Gmail and Close the Browser");  
  }

}
