package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

    public static void scrollToElement(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public static WebElement waitForElementToBeDisplayed(WebDriver driver, By locator){
        WebElement element = driver.findElement(locator);
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(d -> element.isDisplayed());
        return element;
    }

    public static boolean isElementDisplayedByXpath(WebDriver driver, By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception ignored) {
            return false;
        }
    }
}
