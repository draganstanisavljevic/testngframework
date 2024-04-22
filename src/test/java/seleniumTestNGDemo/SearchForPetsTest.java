package seleniumTestNGDemo;

import actions.PetSearchAction;
import enums.EndPoints;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.petstore.SearchResultPageObject;


public class SearchForPetsTest extends BaseTest {


    @Test(groups = "functional", description = "TC1 - successfull search")
    public void searchForPetSuccessfull(){
        System.out.println("The thread ID for searchForPetSuccessfull is " + Thread.currentThread().getId());
        this.driver.get(driver.getCurrentUrl() + EndPoints.CATALOG.endPoint);
        PetSearchAction petSearchAction = new PetSearchAction(driver);
        petSearchAction.searchForPets("fish");
        SearchResultPageObject searchResult = new SearchResultPageObject(this.driver);
        Assert.assertTrue(searchResult.getNameTableHeader().isDisplayed());
        boolean condition = driver.findElements(By.xpath("//table/tbody/tr")).size() > 2;
        Assert.assertTrue(condition, "Search did not give any result");
    }

    @Test(groups = "functional", description = "TC2 - there is no search result")
    public void searchForPetNoResults(){
        System.out.println("The thread ID for searchForPetNoResults is " + Thread.currentThread().getId());
        this.driver.get(driver.getCurrentUrl() + EndPoints.CATALOG.endPoint);
        PetSearchAction petSearchAction = new PetSearchAction(driver);
        petSearchAction.searchForPets("fisherman");
        SearchResultPageObject searchResult = new SearchResultPageObject(this.driver);
        Assert.assertTrue(searchResult.getNameTableHeader().isDisplayed());
        boolean condition = driver.findElements(By.xpath("//table/tbody/tr")).size() == 2;
        Assert.assertTrue(condition, "Expected: no search result. Actually: there is a result");
    }
}
