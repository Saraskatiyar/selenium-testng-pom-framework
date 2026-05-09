package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {

	private WebDriver driver;
	private ElementUtils utils;

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement signup;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement email;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement password;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement submit;

	@FindBy(xpath = "//a[text()=' Logout']")
	private WebElement actualText;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		this.utils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);

	}

	public void clickLogin() {
		utils.click(signup);
	}

	public void enterEmail(String Email) {
		utils.click(email);
		utils.sendKeys(email, Email);

	}

	public void enterPassword(String pwd) {
		utils.sendKeys(password, pwd);
	}

	public void clickSubmit() {
		utils.click(submit);
	}

	public String verifyLogoutText() {
		return utils.getText(actualText);
	}
}
