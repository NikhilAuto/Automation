package Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import StepDefs.PropFileReader;

public class screenPrint {
	
	static PropFileReader property = new PropFileReader();
	
	public static void takeScreenshotandStore(WebDriver driver){
	
	String imgPath = property.getscreenshotPath() + "Screen1" + ".jpg";
		
	File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(s, new File(imgPath));
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("TESTING PIC");
}
}
}