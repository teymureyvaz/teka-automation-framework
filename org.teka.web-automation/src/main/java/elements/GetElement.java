package elements;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
public class GetElement extends GetBy {
    protected WebElement getElement(String jsonKey) {
        By by = getByValue(jsonKey);
        return DriverManager.getInstance().getDriver().findElement(by);
    }
    protected WebElement getElement(By by) {
        return DriverManager.getInstance().getDriver().findElement(by);
    }
    protected List<WebElement> getElements(String jsonKey) {
        By by = getByValue(jsonKey);
        return DriverManager.getInstance().getDriver().findElements(by);
    }
    protected List<WebElement> getElements(By by) {
        return DriverManager.getInstance().getDriver().findElements(by);
    }
}