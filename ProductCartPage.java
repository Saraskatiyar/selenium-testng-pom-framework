package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class ProductCartPage {

	private WebDriver driver;
	private ElementUtils utils;

	// ================= Locators =================

	@FindBy(xpath = "//button[@type='button']")
	private WebElement addToCart;

	@FindBy(xpath = "")
	private WebElement increment;

	@FindBy(xpath = "//u[text()='View Cart']")
	private WebElement viewCart;

	@FindBy(xpath = "//input[@id='quantity']")
	private WebElement inputQuantity;

	@FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_quantity']//button")
	private WebElement verifyQuantity;

	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	private WebElement verifyProceedToCheckout;

	// ================= Constructor =================

	public ProductCartPage(WebDriver driver) {

		this.driver = driver;
		this.utils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);

	}

	// ================= Page Actions =================

	public void enterQuantity(String qty) {
		inputQuantity.clear();
		utils.sendKeys(inputQuantity, qty);
	}

	public void clickAddToCart() {
		utils.click(addToCart);
	}

	public void viewCart() {
		utils.click(viewCart);
	}

	// ================= Data / Verifications =================
	public String getViewCartText() {
		return utils.getText(viewCart);
	}

	public String verifyQuantity() {
		return utils.getText(verifyQuantity);
	}

	public String verifyProceedButton() {
		return utils.getText(verifyProceedToCheckout);
	}

	public boolean getProceedBtn() {
		return verifyProceedToCheckout.isDisplayed();
	}

}
