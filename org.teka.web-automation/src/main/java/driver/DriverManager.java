package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;  // Import WebDriverManager

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getenv("BROWSER") != null ? System.getenv("BROWSER") : "chrome";
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();  // Automatically setup ChromeDriver
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();  // Automatically setup GeckoDriver
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }
            System.out.println("Driver initialized successfully!");
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Driver quit successfully!");
        }
    }
}