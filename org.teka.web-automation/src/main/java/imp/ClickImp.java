package imp;

import com.thoughtworks.gauge.Step;
import driver.DriverManager;
import elements.GetBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickImp {

    WebDriver driver = DriverManager.getInstance().getDriver();

    @Step("Open <browser> and go to <url>")
    public void openBrowserAndNavigate(String browser, String url) {
        DriverManager.getInstance().initializeDriver(browser);
        driver.get(url);
    }

    @Step("Click element <element>")
    public void clickElement(String element) {
        WebElement webElement = driver.findElement(GetBy.getByValue(element));
        webElement.click();
    }

    @Step("Enter <text> to <element>")
    public void enterText(String text, String element) {
        WebElement webElement = driver.findElement(GetBy.getByValue(element));
        webElement.clear();
        webElement.sendKeys(text);
    }

    @Step("Get value of <element>")
    public String getValueOfElement(String element) {
        WebElement webElement = driver.findElement(GetBy.getByValue(element));
        return webElement.getText();
    }
}