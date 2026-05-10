package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import dataproviders.jsonDataProvider;
import pages.ProductCartPage;
import pages.ProductDetailsPage;

@Listeners(listeners.TestListener.class)
public class VerifyCartTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = jsonDataProvider.class)
    public void testVerifyCart(String username, String password)
            throws InterruptedException {   // ✅ ONLY THIS ADDED

        doLogin(username, password);

        ProductDetailsPage productDetail = new ProductDetailsPage(driver);
        ProductCartPage productCart = new ProductCartPage(driver);

        productDetail.clickProduct();
        productDetail.clickViewProduct();
        productCart.enterQuantity("2");
        productCart.clickAddToCart();
        productCart.viewCart();

        String actualQty = productCart.verifyQuantity();
        Assert.assertEquals(actualQty, "49", "Quantity mismatch");

        String proceedBtn = "Proceed To Checkout";
        Assert.assertEquals(productCart.verifyProceedButton().trim(), proceedBtn);
    }
}
