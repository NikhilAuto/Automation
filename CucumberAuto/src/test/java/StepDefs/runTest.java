package StepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources/Features", glue= {"StepDefs"}, monochrome = true) 
//plugin = {"pretty", "html:target/HtmlReports/testresults"} ) 

public class runTest {

}
