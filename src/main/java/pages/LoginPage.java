package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static extnstions.ElementExtensions.waitUntilElementDisplayed;
import static pages.UserRegistrationPage.successMessage;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    public void userLogin(String email,String password){
        waitUntilElementDisplayed(emailField,5);
        typeText(emailField,email);
        typeText(passwordField,password);
        clickButton(loginButton);
        waitUntilElementDisplayed(successMessage,20);
    }
}