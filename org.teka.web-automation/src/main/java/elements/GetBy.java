package elements;

import org.openqa.selenium.By;

public class GetBy {

    /**
     * Method to return a By object based on the locator string.
     * Supports XPath, CSS, ID, Class Name, Name, and Tag Name.
     *
     * @param locator - Locator string, e.g., "//div[@id='example']" or "#username"
     * @return By object corresponding to the locator
     */
    public static By getByValue(String locator) {
        if (locator.startsWith("//") || locator.startsWith("(//")) {
            // XPath locator
            return By.xpath(locator);
        } else if (locator.startsWith("#")) {
            // ID locator using CSS selector format
            return By.id(locator.substring(1));
        } else if (locator.startsWith(".")) {
            // Class name locator using CSS selector format
            return By.className(locator.substring(1));
        } else if (locator.startsWith("[name=")) {
            // Name attribute locator using CSS
            return By.name(locator.substring(6, locator.length() - 1));
        } else if (locator.startsWith("css=")) {
            // CSS selector locator
            return By.cssSelector(locator.substring(4));
        } else if (locator.startsWith("tag=")) {
            // Tag name locator
            return By.tagName(locator.substring(4));
        } else {
            // Default to CSS selector if not explicitly mentioned
            return By.cssSelector(locator);
        }
    }

    /**
     * Method to return a By object for ID locators.
     * @param id - Element ID
     * @return By object for ID locator
     */
    public static By byId(String id) {
        return By.id(id);
    }

    /**
     * Method to return a By object for XPath locators.
     * @param xpath - XPath expression
     * @return By object for XPath locator
     */
    public static By byXPath(String xpath) {
        return By.xpath(xpath);
    }

    /**
     * Method to return a By object for CSS locators.
     * @param cssSelector - CSS selector
     * @return By object for CSS locator
     */
    public static By byCssSelector(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    /**
     * Method to return a By object for Class Name locators.
     * @param className - Class name of the element
     * @return By object for Class Name locator
     */
    public static By byClassName(String className) {
        return By.className(className);
    }

    /**
     * Method to return a By object for Name locators.
     * @param name - Name attribute of the element
     * @return By object for Name locator
     */
    public static By byName(String name) {
        return By.name(name);
    }

    /**
     * Method to return a By object for Tag Name locators.
     * @param tagName - Tag name of the element
     * @return By object for Tag Name locator
     */
    public static By byTagName(String tagName) {
        return By.tagName(tagName);
    }
}