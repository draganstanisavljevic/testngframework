package pageObjects.petstore;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BaseObject;

@Getter
public class SearchResultPageObject extends BaseObject {

    @FindBy(xpath = "//th[contains(text(),'Product ID')]")
    private WebElement productIdTableHeader;

    @FindBy(xpath = "//th[contains(text(),'Name')]")
    private WebElement nameTableHeader;

    public SearchResultPageObject(WebDriver driver) {
        super(driver);
    }
}
