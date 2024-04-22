package seleniumTestNGDemo;

import enums.EndPoints;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.WebDriverUtils;

public class PetNavigationTest extends BaseTest {

    @Test(groups = "functional", dataProvider = "topMenuDataProvider", description = "TC3 - test top navigation menu")
    public void testTopNavigationMenu(String imageName, String pageTitle){
        System.out.println("The thread ID for testTopNavigationMenu is " + Thread.currentThread().getId());
        this.driver.get(driver.getCurrentUrl() + EndPoints.CATALOG.endPoint);
        this.driver.findElement(By.xpath("//img[contains(@src,'" + imageName + "')]")).click();
        Assert.assertTrue(WebDriverUtils.isElementDisplayedByXpath(driver,By.xpath("//h2[contains(text(),'" + pageTitle + "')]")),
                "Page title " + pageTitle + " not found");
    }

    @DataProvider(name = "topMenuDataProvider")
    public Object[][] getData(){

        return new Object[][]
                {
                        { "dog", "Dogs" },
                        { "fish", "Fish" },
                        { "reptiles", "Reptiles" },
                        { "cats", "Cats" },
                        { "birds", "Birds" },
                };
    }
}
