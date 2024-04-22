package actions;

import org.openqa.selenium.WebDriver;
import pageObjects.petstore.HeaderPageObject;

public class PetSearchAction {

    WebDriver driver;
    HeaderPageObject header;

    public PetSearchAction(WebDriver driver){
        this.driver = driver;
        header = new HeaderPageObject(driver);
    }
    public void searchForPets(String petName){
        driver.findElement(header.getSearchInput()).clear();
        driver.findElement(header.getSearchInput()).sendKeys(petName);
        driver.findElement(header.getSearchSubmitButton()).click();
    }

}
