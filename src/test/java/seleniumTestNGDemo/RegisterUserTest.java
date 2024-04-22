package seleniumTestNGDemo;

import actions.HeaderActions;
import actions.LoginFormActions;
import actions.UserRegistrationAction;
import enums.EndPoints;
import modelObjects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.petstore.RegistrationFormPageObject;
import utils.TestUtils;
import utils.WebDriverUtils;

public class RegisterUserTest extends BaseTest {

    private RegistrationFormPageObject registrationForm = new RegistrationFormPageObject(this.driver);
    private User user;;

    @Test(groups = "userAdmin")
    public void testRegisterUser(){
        System.out.println("The thread ID for testRegisterUser is " + Thread.currentThread().getId());
        user = setUser(new User());
        driver.get(driver.getCurrentUrl() + EndPoints.REGISTER_USER.endPoint);
        UserRegistrationAction.submitRegistrationForm(driver, user);
        WebDriverUtils.isElementDisplayedByXpath(driver, By.id("SidebarContent"));
    }

    @Test(groups = "userAdmin", dependsOnMethods = "testRegisterUser", description = "TC6 - log in with valid credentials")
    public void testSigninValidCredentials(){
        System.out.println("The thread ID for testSigninValidCredentials is " + Thread.currentThread().getId());
        HeaderActions headerActions = new HeaderActions(this.driver);
        try{
            headerActions.clickOnSignInLink(driver);
        }catch(StaleElementReferenceException e){
            driver.navigate().refresh();
            headerActions = new HeaderActions(this.driver);
            headerActions.clickOnSignInLink(driver);
        }
        LoginFormActions loginFormActions = new LoginFormActions(driver);
        loginFormActions.enterUsername(user.getUsername());
        loginFormActions.enterPassword(user.getPassword());
        System.out.println("Username for login: " + user.getUsername());
        System.out.println("Password for login: " + user.getPassword());
        loginFormActions.clickLogin();
        Assert.assertTrue(WebDriverUtils.isElementDisplayedByXpath(driver, By.id("SidebarContent")));
    }

    @Test(groups = "userAdmin", dependsOnMethods = "testRegisterUser", description = "TC7 - log in with invalid password")
    public void testSignInInvalidPassword(){
        System.out.println("The thread ID for testSignInInvalidPassword is " + Thread.currentThread().getId());
        HeaderActions headerActions = new HeaderActions(this.driver);
        try{
            headerActions.clickOnSignInLink(driver);
        }catch(StaleElementReferenceException e){
            driver.navigate().refresh();
            headerActions = new HeaderActions(this.driver);
            headerActions.clickOnSignInLink(driver);
        }
        LoginFormActions loginFormActions = new LoginFormActions(driver);
        loginFormActions.enterUsername(user.getUsername());
        System.out.println("Username for invalid login: " + user.getUsername());
        loginFormActions.enterPassword("gygygyygyg");
        loginFormActions.clickLogin();
        String errorMesage = loginFormActions.getErrorMesage();
        Assert.assertEquals(errorMesage, "Invalid username or password. Signon failed.",
                "Error message was not found");
    }

    @Test(enabled = false, description = "This method is demo for exclude test")
    public void thisShouldNotBeExecuted(){
        System.out.println("The thread ID for thisShouldNotBeExecuted is " + Thread.currentThread().getId());
        System.out.println("I should not be printed");
    }

    @Test(priority = 1, description = "This method is demo for exclude test in XML file")
    public void ForFirefox(){
        System.out.println("The thread ID for ForFirefox is " + Thread.currentThread().getId());
        System.out.println("I should not be printed for firefox run");
    }

    private User setUser(User user){
        System.out.println("I have just created new user");
        user.setUsername(TestUtils.getRandomAlphabeticalString(12));
        user.setCity("gyyg");
        user.setEmail("gygyyg@ygyg.com");
        user.setCountry("ijijijij");
        user.setAddress1("TFtffttf");
        user.setAddress2("huuhuhuhuh");
        user.setPassword("uhuhuhuh");
        user.setFirstName("tftftf");
        user.setPhone("777887678");
        user.setState("yggyyggy");
        user.setZip("234234");
        user.setLastName("huhuuhuuh");
        user.setRepeatedPassword("uhuhuhuh");
        user.setLastName("gygygygy");

        return user;
    }

}
