package webDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {
	private ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	WebDriver wd;
	
	public void driverSetup()
	{
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		setDriver(wd);
	}
	public void setDriver(WebDriver wd)
	{
		this.tlDriver.set(wd);
	}
	public WebDriver getDriver() {
		return this.tlDriver.get();
	}
}
