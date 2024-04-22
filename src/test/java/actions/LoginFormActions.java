package actions;

import org.openqa.selenium.WebDriver;
import pageObjects.petstore.LoginFormPageObject;

public class LoginFormActions {

    WebDriver driver;
    LoginFormPageObject loginForm;

    public LoginFormActions(WebDriver driver){
        this.driver = driver;
        loginForm = new LoginFormPageObject(driver);
    }

    public void enterUsername(String user) {
        driver.findElement(loginForm.getUsername()).clear();
        driver.findElement(loginForm.getUsername()).sendKeys(user);
    }
    public void enterPassword(String pass) {
        driver.findElement(loginForm.getPassword()).clear();
        driver.findElement(loginForm.getPassword()).sendKeys(pass);
    }
    public void clickLogin() {
        driver.findElement(loginForm.getSignon()).click();
    }

    public String getErrorMesage(){
        return driver.findElement(loginForm.getErrorMesage()).getText();
    }
}
