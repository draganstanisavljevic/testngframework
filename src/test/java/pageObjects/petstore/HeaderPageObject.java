package pageObjects.petstore;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BaseObject;

@Getter
public class HeaderPageObject extends BaseObject {

    private By logo = By.cssSelector("#LogoContent");
    private By cartIcon = By.cssSelector("cartIcon");
    private By signInLink = By.linkText("Sign In");
    private By myAccountLink = By.linkText("My Account");
    private By signOutLink = By.linkText("Sign out");
    private By helpLink = By.linkText("?");
    private By searchInput = By.cssSelector("#SearchContent [name=keyword]");
    private By searchSubmitButton = By.cssSelector("#SearchContent [name=searchProducts]");

    public HeaderPageObject(WebDriver driver) {
        super(driver);
    }
}
