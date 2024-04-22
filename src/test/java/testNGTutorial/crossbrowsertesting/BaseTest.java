package testNGTutorial.crossbrowsertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    public WebDriver driver;


    @Parameters("browser")
    @BeforeClass
    // Passing Browser parameter from TestNG xml
    public void beforeTest(@Optional("chrome") String brows) {

        // If the browser is Firefox, then do this
        if(brows.equalsIgnoreCase("firefox")) {
            //Initializing the firefox driver (Gecko)
            driver = new FirefoxDriver();
        }else if (brows.equalsIgnoreCase("chrome")) {
            //Initialize the chrome driver
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver");
            driver = new ChromeDriver();
        }

        // Enter the website address in the browser
        driver.get("https://www.google.com");
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }


}
