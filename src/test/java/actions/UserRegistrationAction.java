package actions;

import modelObjects.User;
import org.openqa.selenium.WebDriver;
import pageObjects.petstore.RegistrationFormPageObject;

public class UserRegistrationAction {

    public static void submitRegistrationForm(WebDriver driver, User user){
        RegistrationFormPageObject registrationForm = new RegistrationFormPageObject(driver);
        registrationForm.getUsername().sendKeys(user.getUsername());
        registrationForm.getPassword().sendKeys(user.getPassword());
        registrationForm.getRepeatedPassword().sendKeys(user.getRepeatedPassword());
        registrationForm.getFirstName().sendKeys(user.getFirstName());
        registrationForm.getLastName().sendKeys(user.getLastName());
        registrationForm.getEmail().sendKeys(user.getEmail());
        registrationForm.getCity().sendKeys(user.getCity());
        registrationForm.getPhone().sendKeys(user.getPhone());
        registrationForm.getAddress1().sendKeys(user.getAddress1());
        registrationForm.getAddress2().sendKeys(user.getAddress2());
        registrationForm.getState().sendKeys(user.getState());
        registrationForm.getZip().sendKeys(user.getZip());
        registrationForm.getCountry().sendKeys(user.getCountry());
        System.out.println("Username for registration: " + user.getUsername());
        System.out.println("Password for registration: " + user.getPassword());
        registrationForm.getSubmitButton().click();
    }
}
