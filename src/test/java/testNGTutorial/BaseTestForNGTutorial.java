package testNGTutorial;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CalculateResolution;
import utils.ConfigUtils;
import utils.WebDriverUtils;

import java.util.concurrent.TimeUnit;

public class BaseTestForNGTutorial {

    final static Logger logger = Logger.getLogger(BaseTestForNGTutorial.class);

    public WebDriver driver;
    public WebDriverWait wait;
    public ConfigUtils configUtils;
    public static final String CONFIG_PATH = "src/test/resources/config/";

    public void setup() {
        System.setProperty("browser", "chrome");
        System.setProperty("resolution", "dfgdf");
        System.setProperty("env", "qa");
        if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver");
            ChromeOptions options=new ChromeOptions();
            options.addArguments(CalculateResolution.getResolution());
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            driver=new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (System.getProperty("browser").equalsIgnoreCase("FF")) {
            //set uo Firefox driver
        } else if (System.getProperty("browser").equalsIgnoreCase("IE")) {
            // setup IE driver
        }
        configUtils = getConfig(System.getProperty("env"));
        driver.get(configUtils.getData("url"));
        logger.info("Open the application");
    }

    protected void acceptRisk(){
        WebElement riskAlert = WebDriverUtils.waitForElementToBeDisplayed(driver, By.id("js-riskCloseButton"));
        riskAlert.click();
    }

    public void teardown() {
        driver.quit();
    }

    private ConfigUtils getConfig(String env){
        String path = String.format("%s%s.properties", CONFIG_PATH, env);
        configUtils = new ConfigUtils(path);
        return configUtils;
    }

}