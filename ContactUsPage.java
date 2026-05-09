package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class ContactUsPage {

	private WebDriver driver;
	private ElementUtils utils;

	// ================== Locators =================

	@FindBy(xpath = "//a[@href='/contact_us']")
	WebElement contactUs;

	@FindBy(xpath = "//input[@name='name']")
	WebElement enterName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement enterEmail;

	@FindBy(xpath = "//input[@name='subject']")
	WebElement enterSubject;

	@FindBy(xpath = "//textarea[@name='message']")
	WebElement enterMessage;

	@FindBy(xpath = "//input[@type='file']")
	WebElement uploadFile;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	// ============= Verify Text Locators =============

	@FindBy(xpath = "//div[@class='status alert alert-success']")
	WebElement verifySuccessMessage;

	// ============ Constructor ==================

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		this.utils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}

	// ============ Action Methods ==================
	
	public void clickOnContactUs() {
		utils.click(contactUs);
	}

	public void enterDetails(String name, String email, String subject, String message) {
		utils.sendKeys(enterName, name);
		utils.sendKeys(enterEmail, email);
		utils.sendKeys(enterSubject, subject);
		utils.sendKeys(enterMessage, message);
	}

	public void clickUpload(String path) {
		utils.uploadFile(uploadFile, path);
	}

	public void clickOnSubmit() {
		utils.click(submit);
	}

	public void acceptTheAlert() {
		utils.acceptAlert();
	}
	// ============ Assertions =============

	public String verifySuccessText() {
		return utils.getText(verifySuccessMessage);
	}
}
