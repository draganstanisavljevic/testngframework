package pageObjects.petstore;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BaseObject;

@Getter
public class LoginFormPageObject extends BaseObject {

    private By username = By.name("username");
    private By password = By.name("password");
    private By signon = By.name("signon");
    private By errorMesage = By.cssSelector(".messages li");

    public LoginFormPageObject(WebDriver driver) {
        super(driver);
    }

}
