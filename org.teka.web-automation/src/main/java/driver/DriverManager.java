package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    // Singleton instance of DriverManager
    private static DriverManager instance = null;

    // Single WebDriver instance
    private WebDriver driver;

    // Private constructor to prevent instantiation
    private DriverManager() {}

    /**
     * Public method to get the singleton instance of DriverManager.
     *
     * @return DriverManager instance
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) {
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    /**
     * Initializes the WebDriver based on the browser type if not already initialized.
     *
     * @param browser Browser name, e.g., "chrome", "firefox", "edge"
     */
    public void initializeDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            // Maximize the browser window after initialization
            driver.manage().window().maximize();
        }
    }

    /**
     * Gets the current WebDriver instance.
     *
     * @return WebDriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Quits the WebDriver instance and sets the driver to null.
     */
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Set the driver to null to allow reinitialization
        }
    }
}