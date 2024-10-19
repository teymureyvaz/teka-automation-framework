package base;

import driver.DriverManager;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;

public class BaseBrowser {

    @BeforeScenario
    public void setup() {
        WebDriver driver = DriverManager.getDriver();  // Ensure this is called before each test scenario
        System.out.println("Driver setup complete!");  // Debugging
    }

    @AfterScenario
    public void teardown() {
        DriverManager.quitDriver();
    }
}