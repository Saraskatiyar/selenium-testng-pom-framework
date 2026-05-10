package tests;
import java.util.Map;
import org.testng.annotations.Listeners;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;

@Listeners(TestListener.class)
public class ProductDetailTest extends BaseTest {
	@Test(dataProvider = "loginData", dataProviderClass = dataproviders.ExcelDataProviders.class)

	public void BaseTest(String email, String pwd) throws InterruptedException {

		doLogin(email, pwd);
		ProductDetailsPage pd = new ProductDetailsPage(driver);
		pd.clickProduct();
		pd.clickViewProduct();

		Map<String, String> actualDetails = pd.getProductDetails();
		Assert.assertEquals(actualDetails.get("Name"), "Blue Top");
		Assert.assertEquals(actualDetails.get("Category"), "Category: Women > Tops");
		Assert.assertEquals(actualDetails.get("Price"), "Rs. 500");
		Assert.assertEquals(actualDetails.get("Availability"), "Availability: In Stock");
		Assert.assertEquals(actualDetails.get("Condition"), "Condition: New");
		Assert.assertEquals(actualDetails.get("Brand"), "Brand: Polo");

	}

}
