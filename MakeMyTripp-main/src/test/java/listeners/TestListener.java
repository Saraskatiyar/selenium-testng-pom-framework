package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import tests.BaseTest;
import utils.DriverFactory;
import utils.ExtentManager;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart: " + result.getMethod().getMethodName());
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		testThread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ExtentTest test = testThread.get();
		if (test != null) {
			test.log(Status.PASS, "Test Passed");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("onTestFailure: " + result.getMethod().getMethodName());

		ExtentTest test = testThread.get();

		if (test == null) {
			System.out.println("testThread is null, onTestStart might not have been called.");
			return;
		}

		test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

		try {
			WebDriver driver = DriverFactory.getDriver();

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String folder = System.getProperty("user.dir") + "/screenshots/";
			String path = folder + result.getMethod().getMethodName() + "_" + timestamp + ".png";

			File screenshotsDir = new File(folder);
			if (!screenshotsDir.exists()) {
				screenshotsDir.mkdirs();
			}

			FileUtils.copyFile(src, new File(path));
			test.addScreenCaptureFromPath(path);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish: Flushing extent reports");
		extent.flush();
	}
}
