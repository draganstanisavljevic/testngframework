package seleniumTestNGDemo;

import enums.EndPoints;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ShoppingFeatureTest extends BaseTest {

    @Test(groups = "functional", description = "TC7 - shopping feature")
    public void testShoppingFeature(){
        System.out.println("The thread ID for testShoppingFeature is " + Thread.currentThread().getId());
        this.driver.get(driver.getCurrentUrl() + EndPoints.CATALOG.endPoint);
        this.driver.findElement(By.xpath("//img[contains(@src,'" + "fish" + "')]")).click();
        this.driver.findElement(By.linkText("FI-SW-01")).click();
        this.driver.findElement(By.linkText("EST-1")).click();
        this.driver.findElement(By.linkText("Add to Cart")).click();
        this.driver.findElement(By.name("EST-1")).clear();
        this.driver.findElement(By.name("EST-1")).sendKeys("2");
        this.driver.findElement(By.name("updateCartQuantities")).click();
        List<WebElement> rows = this.driver.findElements(By.xpath("//tr"));
        List<WebElement> columns = rows.get(1).findElements(By.xpath("//td"));
        String unitPrice = columns.get(5).getText();
        String totalPrice = columns.get(6).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(unitPrice.equalsIgnoreCase("$16.50"), "Unit price is different than expected");
        softAssert.assertTrue(totalPrice.equalsIgnoreCase("$33.00"), "Total price is different than expected");
        softAssert.assertAll();
    }
}
