package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccountPage {

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Open New Account']")
	WebElement openNewAcc;

	@FindBy(xpath = "//select[@id='type']")
	WebElement accTypeDropdown;

	@FindBy(xpath = "//option[@value='1']")
	WebElement savingAcc;

	@FindBy(xpath = "//select[@id='fromAccountId']")
	WebElement accIDDropdown;

	@FindBy(xpath = "//option[@value='14565']")
	WebElement accID;

	@FindBy(xpath = "//input[@value='Open New Account']")
	WebElement submit;

	@FindBy(xpath = "//p[text()='Congratulations, your account is now open.']")
	WebElement actualText;

	public OpenAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOpenNewAcc() {
		openNewAcc.click();

	}

	public void clickAccTypeDropdown() {
		Select select = new Select(accTypeDropdown);
		select.selectByIndex(0);

	}

	public void selectAccType() {
		savingAcc.click();

	}

	public void clickAccIdDropdown() {
		WebElement Ele = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromAccountId")));
		Select select = new Select(accIDDropdown);
		select.selectByIndex(0);

	}

	public void selectAccId() {
		accID.click();

	}

	public void clickSubmit() {
		submit.click();

	}

	public String verifyNewOpenedAcc() {
//		System.out.println(accID.getText());
		return actualText.getText();
	}
}
