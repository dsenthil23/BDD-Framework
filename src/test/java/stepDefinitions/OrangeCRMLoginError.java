package stepDefinitions;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webDriver.WebDriverSetup;


public class OrangeCRMLoginError {
	static WebDriver wd;
	@Given("user is on the login page2")
	public void user_is_on_the_login_page() {
		WebDriverSetup driver = new WebDriverSetup();
		driver.driverSetup();
		wd = driver.getDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	    System.out.println("Site Launched with Sign in page");
	}

	@When("user has invalid credentials")
	public void user_has_invalid_credentials() {
		wd.findElement(By.xpath("//input[@id='txtUsername']")).clear();
	    wd.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	    wd.findElement(By.xpath("//input[@id='txtPassword']")).clear();
	    wd.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin1234");
	    System.out.println("Entering Valid Login Details");
	}

	@And("user attempts to submit the login form2")
	public void user_attempts_to_submit_the_login_form() {
		wd.findElement(By.xpath("//input[@id='btnLogin']")).click();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    System.out.println("Clicking on Sign in Button");
	}

	@Then("user gets the invalid credential alert")
	public void user_gets_the_invalid_credential_alert() {
		String actualError = "Invalid credentials";
		String errorMessage = wd.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actualError, errorMessage);
		wd.quit();
	}

}
