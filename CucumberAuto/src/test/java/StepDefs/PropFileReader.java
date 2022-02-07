package StepDefs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropFileReader {

		private Properties property;
		private final String propertyFilePath= "configs//config.properties";

		public PropFileReader(){
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				property = new Properties();
				try {
					property.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}		
		}
		
		public String getTestURL(){
			String driverPath = property.getProperty("TestURL");
			if(driverPath!= null) return driverPath;
			else throw new RuntimeException("TestURL not specified in the Configuration.properties file.");		
		}
		
		public long getImplicitlyWait() {		
			String implicitlyWait = property.getProperty("implicitlyWait");
			if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
			else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
		}
		
		public String getchromeDriverPath() {
//			System.out.println(property.getProperty("chromeDriverPath"));
			String chromeDriverPath = property.getProperty("chromeDriverPath");
			if(chromeDriverPath != null) return chromeDriverPath;
			else throw new RuntimeException("chromeDriverPath not specified in the Configuration.properties file.");
		}
		
		public String getmozillaDriverPath() {
//			System.out.println(property.getProperty("chromeDriverPath"));
			String mozillaDriverPath = property.getProperty("mozillaDriverPath");
			if(mozillaDriverPath != null) return mozillaDriverPath;
			else throw new RuntimeException("mozillaDriverPath not specified in the Configuration.properties file.");
		}
}
