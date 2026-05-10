package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class ProductDetailsPage {

	private WebDriver driver;
	private ElementUtils utils;

	@FindBy(xpath = "//a[@href='/products']")
	private WebElement products;

	@FindBy(xpath = "//a[@href='/product_details/1']")
	private WebElement viewProduct;

	@FindBy(xpath = "//h2[text()='Blue Top']")
	private WebElement name;

	@FindBy(xpath = "//p[text()='Category: Women > Tops']")
	private WebElement category;

	@FindBy(xpath = "//span[text()='Rs. 500']")
	private WebElement price;

	@FindBy(xpath = "//p[contains(text(),'In Stock')]")
	private WebElement availability;

	@FindBy(xpath = "//p[contains(text(),'New')]")
	private WebElement condition;

	@FindBy(xpath = "//p[contains(text(),'Polo')]")
	private WebElement brand;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.utils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickProduct() {
		utils.click(products);
		utils.waitForUrlContains("/products");
	}

	public void clickViewProduct() {
		utils.click(viewProduct);
		utils.waitForVisible(name);
	}

	public Map<String, String> getProductDetails() {
		Map<String, String> details = new HashMap<>();
		details.put("Name", utils.getText(name));
		details.put("Category", utils.getText(category));
		details.put("Price", utils.getText(price));
		details.put("Availability", utils.getText(availability));
		details.put("Condition", utils.getText(condition));
		details.put("Brand", utils.getText(brand));
		return details;
	}
}
