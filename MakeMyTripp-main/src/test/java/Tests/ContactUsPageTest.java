package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import dataproviders.jsonDataProvider;
import pages.ContactUsPage;

@Listeners(listeners.TestListener.class)
public class ContactUsPageTest extends BaseTest {

	@Test(dataProvider = "loginData", dataProviderClass = jsonDataProvider.class)
	public void testVerifyContact(String username, String password) throws InterruptedException { // ✅ ONLY THIS ADDED
		doLogin(username, password);
		ContactUsPage contactus = new ContactUsPage(driver);

		contactus.clickOnContactUs();
		contactus.enterDetails("Prabhat", "test@gmail.com", "TestSubject", "This is a test code");
		Thread.sleep(2000);
		contactus.clickUpload("C:\\Users\\qapra\\Downloads\\Upload_Selenium.png");
		Thread.sleep(2000);
		contactus.clickOnSubmit();
		Thread.sleep(2000);
		contactus.acceptTheAlert();
		Thread.sleep(2000);
		String actualText = "Success! Your details have been submitted successfully.";
		Assert.assertEquals(contactus.verifySuccessText(), actualText);
	}
}
