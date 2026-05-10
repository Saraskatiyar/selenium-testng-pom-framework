package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ===================== WAITS =====================

    public void waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForUrlContains(String value) {
        wait.until(ExpectedConditions.urlContains(value));
    }

    
    // ===================== ACTIONS =====================

    public void click(WebElement element) {
        try {
            waitForClickable(element);
            element.click();
        } catch (Exception e) {
            jsClick(element); // fallback for ads / overlays
        }
    }

    public void sendKeys(WebElement element, String value) {
        waitForVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    public String getText(WebElement element) {
        waitForVisible(element);
        return element.getText().trim();
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    
    public boolean isDisplayed(WebElement element) {
    	try {
    		waitForVisible(element);
    		return element.isDisplayed();
    	}catch(Exception e) {
    		return false;
    	}
    }
    
    public void waitForPageLoad() {
    	new WebDriverWait(driver, Duration.ofSeconds(10)).until(WebDriver -> ((JavascriptExecutor) WebDriver).executeScript("return document.readyState").equals("complete"));
    }
    
    public void scrollIntoView(WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public void uploadFile(WebElement element, String filePath) {
    	waitForVisible(element);
    	element.sendKeys(filePath);
    }
    
    public void acceptAlert() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    	alert.accept();
    }
    
    public void dismissAlert() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    	alert.dismiss();
    }
    
    public String getAlertText() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    	return alert.getText();
    }
    
    public void waitForPresence(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.refreshed(
                        ExpectedConditions.presenceOfElementLocated(element)));
    }
    
    //clearAndType()
    //clickIfVisible()
    //getAttribute()

}
