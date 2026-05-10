package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class screenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

        try {
            Files.createDirectories(new File("screenshots").toPath());
            Files.copy(srcFile.toPath(), new File(screenshotPath).toPath());
        } catch (IOException e) {
            System.out.println("Screenshot saving failed: " + e.getMessage());
        }

        return screenshotPath;
    }
}
