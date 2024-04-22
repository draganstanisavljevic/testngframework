package pageObjects.petstore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BaseObject;

public class ShoppingCartPO extends BaseObject {

    @FindBy(name = "updateCartQuantities")
    private WebElement logo;


    public ShoppingCartPO(WebDriver driver) {
        super(driver);
    }
}
