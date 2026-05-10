package tests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dataproviders.jsonDataProvider;
import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest {
	
	
	@Test(dataProvider = "loginData", dataProviderClass = jsonDataProvider.class)
	public void loginTest(String username, String password) throws InterruptedException {
		
		doLogin(username, password);
		
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		String expText = "Logout";
		Assert.assertEquals(loginPage.verifyLogoutText().trim(), expText);
	}
}
