package pageObjects.petstore;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BaseObject;

@Getter
public class RegistrationFormPageObject extends BaseObject {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "repeatedPassword")
    private WebElement repeatedPassword;

    @FindBy(name = "account.firstName")
    private WebElement firstName;

    @FindBy(name = "account.lastName")
    private WebElement lastName;

    @FindBy(name = "account.email")
    private WebElement email;

    @FindBy(name = "account.phone")
    private WebElement phone;

    @FindBy(name = "account.address1")
    private WebElement address1;

    @FindBy(name = "account.address2")
    private WebElement address2;

    @FindBy(name = "account.city")
    private WebElement city;

    @FindBy(name = "account.state")
    private WebElement state;

    @FindBy(name = "account.zip")
    private WebElement zip;

    @FindBy(name = "account.country")
    private WebElement country;

    @FindBy(name = "newAccount")
    private WebElement submitButton;


    public RegistrationFormPageObject(WebDriver driver) {
        super(driver);
    }
}


