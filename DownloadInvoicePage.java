package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class DownloadInvoicePage {
	private WebDriver driver;
	private ElementUtils utils;

//  ===========  Locators  ==========

	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	private WebElement proceedToCheckout;

	@FindBy(name = "message")
	private WebElement enterMessage;

	@FindBy(xpath = "//a[text()='Place Order']")
	private WebElement placeOrderBtn;

	@FindBy(xpath = "//input[@name='name_on_card']")
	private WebElement nameOnCard;

	@FindBy(xpath = "//input[@name='card_number']")
	private WebElement cardNum;

	@FindBy(xpath = "//input[@name='cvc']")
	private WebElement cvcInput;

	@FindBy(xpath = "//input[@name='expiry_month']")
	private WebElement expiryMonthInput;

	@FindBy(xpath = "//input[@name='expiry_year']")
	private WebElement expiryYearInput;

	@FindBy(xpath = "//button[@id='submit']")
	private WebElement payAndConfirmOrderBtn;

	@FindBy(xpath = "//a[text()='Download Invoice']")
	private WebElement downloadInvoiceBtn;

	// ========== Verification Locators ==========

	@FindBy(id = "address_delivery")
	private WebElement verifyAddressDetails;

	@FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
	private WebElement verifyOrderConfirmMessage;

	// ============= Constructor ==================

	public DownloadInvoicePage(WebDriver driver) {
		this.driver = driver;
		this.utils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}

	// ========== Action Items ==========

	public void clickProceedToCheckout() {
		utils.click(proceedToCheckout);
	}

	public String verifyCheckout() {
		return utils.getText(verifyAddressDetails);
	}

	public void enterComment(String comment) {
		utils.sendKeys(enterMessage, comment);
	}

	public void clickPlaceOrder() {
		utils.click(placeOrderBtn);
	}

	public void enterPaymentDetails(String cardHolderName, String cardNumber, String cvc, String expiration,
			String year) {
//		utils.waitForPresence((By) nameOnCard);
//		WebElement element = driver.findElement((By) nameOnCard);
//	    utils.scrollIntoView(element);
//	    
		utils.sendKeys(nameOnCard, cardHolderName);
		utils.sendKeys(cardNum, cardNumber);
		utils.sendKeys(cvcInput, cvc);
		utils.sendKeys(expiryMonthInput, expiration);
		utils.sendKeys(expiryYearInput, year);
	}

	public void clickPayAndConfirmOrder() {
		utils.click(payAndConfirmOrderBtn);
	}

	public String verifyOrderPlacedMessage() {
		return utils.getText(verifyOrderConfirmMessage);
	}

	public void clickDownloadBtn() {
		utils.click(downloadInvoiceBtn);
	}
}