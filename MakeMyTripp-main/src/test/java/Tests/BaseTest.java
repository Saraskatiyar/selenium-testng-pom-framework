package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import pages.LoginPage;
import utils.DriverFactory;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		DriverFactory.initDriver("chrome");
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(30));

		System.out.println("Navigating to site...");
		driver.get("https://automationexercise.com/");
		System.out.println("Page loaded.");
	}

	public void doLogin(String username, String password) throws InterruptedException {
		LoginPage login = new LoginPage(driver);

		Thread.sleep(2000);
		login.clickLogin();
		Thread.sleep(2000);
		login.enterEmail(username);
		login.enterPassword(password);
		login.clickSubmit();
		Thread.sleep(2000);
		String expText = "Logout";
		Assert.assertEquals(login.verifyLogoutText().trim(), expText, "❌ Login failed: Logout button not visible");
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
