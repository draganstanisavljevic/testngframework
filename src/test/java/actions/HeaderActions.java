package actions;

import org.openqa.selenium.WebDriver;
import pageObjects.petstore.HeaderPageObject;
import pageObjects.petstore.LoginFormPageObject;

public class HeaderActions {

    private WebDriver driver;
    private HeaderPageObject header;

    public HeaderActions(WebDriver driver){
        this.driver = driver;
        header = new HeaderPageObject(driver);
    }

    public void clickOnSignInLink(WebDriver driver){
        driver.findElement(header.getSignInLink()).click();

    }
}
