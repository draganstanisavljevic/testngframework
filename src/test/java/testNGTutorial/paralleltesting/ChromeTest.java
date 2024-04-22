package testNGTutorial.paralleltesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTest {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test Thread Number Is " + Thread.currentThread().getId());
        //driver = new ChromeDriver();
    }

    @Test(threadPoolSize = 4, invocationCount = 4, timeOut = 1000)
    public void ChromeTestMethod()
    {
        //Initialize the chrome driver
        System.out.println("The thread ID for ChromeTest class is "+ Thread.currentThread().getId());
        //driver.get("https://www.demoqa.com");
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test Thread Number Is " + Thread.currentThread().getId());
        //driver.quit();
    }
}
