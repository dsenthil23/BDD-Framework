package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webDriver.WebDriverSetup;
public class OrangeCRMLogin {
	static WebDriver wd;

	
	
	@Given("user is on the Login page")
	public void user_is_on_the_Login_page() {
		WebDriverSetup driver = new WebDriverSetup();
		driver.driverSetup();
		wd = driver.getDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	    System.out.println("Site Launched with Sign in page");
	}

	@When("user has valid credentials")
	public void user_has_valid_credentials() {
		wd.findElement(By.xpath("//input[@id='txtUsername']")).clear();
	    wd.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	    wd.findElement(By.xpath("//input[@id='txtPassword']")).clear();
	    wd.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
	    System.out.println("Entering Valid Login Details");
	}

	@And("user attempts to submit the login form")
	public void user_attempts_to_submit_the_login_form() {
		wd.findElement(By.xpath("//input[@id='btnLogin']")).click();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    System.out.println("Clicking on Sign in Button");
	}

	@Then("user landed on the user dashboard page")
	public void user_landed_on_the_user_dashboard_page() {
		wd.findElement(By.xpath("//a[@id='welcome']")).click();
	    wd.findElement(By.linkText("Logout")).click();
	    System.out.println("User reaches Dashboard Page");
	    wd.quit();
	}

}
