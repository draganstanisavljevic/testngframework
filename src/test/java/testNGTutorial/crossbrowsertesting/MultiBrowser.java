package testNGTutorial.crossbrowsertesting;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MultiBrowser extends  BaseTest{

    // Once Before method is completed, Test method will start
    @Test public void login() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
    }

}
