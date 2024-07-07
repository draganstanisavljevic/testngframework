package seleniumTestNGDemo;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.CalculateResolution;
import utils.ConfigUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    final static Logger logger = Logger.getLogger(BaseTest.class);

    public WebDriver driver;
    public WebDriverWait wait;
    public ConfigUtils configUtils;
    public static final String CONFIG_PATH = "src/test/resources/config/";

    @Parameters({"brows"})
    @BeforeClass
    public void startTest(@Optional("chrome") String browser) throws MalformedURLException {
        setup(browser);
    }

    public void setup(String browser) throws MalformedURLException {
        System.setProperty("brows", browser);
        if(System.getProperty("env") == null){
            System.setProperty("env", "qa");
        }
        if (System.getProperty("brows").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver");
            ChromeOptions options=new ChromeOptions();
            options.addArguments(CalculateResolution.getResolution());
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            //driver=new ChromeDriver(options);
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.LINUX);
            //URL gridURL = new URL("http://localhost:4444"); for local grid
            URL gridURL = new URL("http://selenium-hub:4444");
            driver = new RemoteWebDriver(gridURL, cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (System.getProperty("brows").equalsIgnoreCase("firefox")) {
            //set uo Firefox driver
//            driver = new FirefoxDriver();
//            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/firefox/geckodriver");
//            driver =new FirefoxDriver();
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("firefox");
            cap.setPlatform(Platform.LINUX);
            //URL gridURL = new URL("http://localhost:4444"); for local grid
            URL gridURL = new URL("http://selenium-hub:4444");
            driver = new RemoteWebDriver(gridURL, cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (System.getProperty("brows").equalsIgnoreCase("IE")) {
            // setup IE driver
        }
        configUtils = getConfig(System.getProperty("env"));
        driver.get(configUtils.getData("url"));
        logger.info("Open the application");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @BeforeMethod(onlyForGroups = "userAdmin")
    public void cleanDB(){
        System.out.println("This method should be executed only before " +
                                            "tests belonging to 'userAdmin' group");
    }

    private ConfigUtils getConfig(String env){
        String path = String.format("%s%s.properties", CONFIG_PATH, env);
        configUtils = new ConfigUtils(path);
        return configUtils;
    }

}
