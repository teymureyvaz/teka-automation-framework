package imp;

import driver.DriverManager;
import base.BaseBrowser;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ClickImp {

    @Step("Open browser and go to <url>")
    public void openBrowser(String url) {
        WebDriver driver = DriverManager.getDriver();  // Ensure driver is initialized
        System.out.println("Navigating to URL: " + url);  // Debugging
        driver.get(url);  // Navigate to the specified URL
    }

    @Step("Click element <element>")
    public void clickElement(String element) {
        WebDriver driver = DriverManager.getDriver();  // Ensure driver is initialized
        System.out.println("Clicking element: " + element);  // Debugging
        driver.findElement(By.cssSelector(element)).click();
    }
}