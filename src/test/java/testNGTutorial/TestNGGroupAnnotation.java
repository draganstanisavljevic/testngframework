package testNGTutorial;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestNGGroupAnnotation extends BaseTestForNGTutorial {

    // Saving the expected title of the Webpage
    String title = "ToolsQA - Demo Website For Automation";

    @BeforeClass(alwaysRun = true )
    public void startTest() throws Exception {
        setup();
    }


    @Test
    public void starting_point(){
        System.out.println("This is the starting point of the test");
        //Initialize Chrome Driver
        //driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        driver.get("https://demoqa.com/");
    }


    @Test(groups = { "demo" }, dependsOnMethods = "click_element")
    public void checkTitle() {
        driver.get("https://demoqa.com/");
        String testTitle = "DEMOQA";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, testTitle);
    }

    @Test(groups = { "demo" })
    public void click_element() {
        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[1]/a")).click();
        System.out.println("Home Page heading is displayed");
    }

    @AfterClass
    public void stopTest(){
        teardown();
    }
}
