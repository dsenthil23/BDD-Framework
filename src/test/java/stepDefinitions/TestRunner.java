package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/features", 
glue = {"stepDefinitions"}, 
monochrome=true, 
plugin={"pretty", "junit:result/JUNITReport/report.xml","json:result/jsonREport/report.json", "html:result/HTMLReport"})
public class TestRunner {

}
