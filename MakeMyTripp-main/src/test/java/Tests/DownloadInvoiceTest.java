package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dataproviders.jsonDataProvider;
import pages.DownloadInvoicePage;
import pages.ProductCartPage;
import pages.ProductDetailsPage;

@Listeners(listeners.TestListener.class)

public class DownloadInvoiceTest extends BaseTest {

	@Test(dataProvider = "loginData", dataProviderClass = jsonDataProvider.class)

	public void verifyDownloadReceipt(String username, String password) throws InterruptedException {

		doLogin(username, password);

		ProductDetailsPage productDetail = new ProductDetailsPage(driver);
		ProductCartPage productCart = new ProductCartPage(driver);
		DownloadInvoicePage invoicePage = new DownloadInvoicePage(driver);

		productDetail.clickProduct();
		productDetail.clickViewProduct();
		productCart.enterQuantity("2");
		productCart.clickAddToCart();
		productCart.viewCart();

		// String actualQty = productCart.verifyQuantity();
		// Assert.assertEquals(actualQty, "4", "Quantity mismatch");

		String proceedBtn = "Proceed To Checkout";
		Assert.assertEquals(productCart.verifyProceedButton().trim(), proceedBtn);

		invoicePage.clickProceedToCheckout();
		invoicePage.enterComment("I purchased the product");
		invoicePage.clickPlaceOrder();
		invoicePage.enterPaymentDetails("Prabhat", "1234567890", "123", "03", "2025");
		invoicePage.clickPayAndConfirmOrder();
		invoicePage.clickDownloadBtn();

	}
}
