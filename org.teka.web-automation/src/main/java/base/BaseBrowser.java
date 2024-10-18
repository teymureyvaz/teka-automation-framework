package base;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseBrowser {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Get the browser name from system property or use chrome by default
        String browser = System.getProperty("browser", "chrome");

        // Initialize the driver using Singleton DriverManager
        DriverManager.getInstance().initializeDriver(browser);
        driver = DriverManager.getInstance().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver after each test method
        DriverManager.getInstance().quitDriver();
    }
}