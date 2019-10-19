package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static extnstions.ElementExtensions.scrollIntoView;

public class UserRegistrationPage extends PageBase {

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameFiled;

    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    WebElement mobileNumberFiled;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    WebElement confirmPasswordFiled;

    @FindBy(xpath = "//button[contains(text(),'Sign Up')]")
    WebElement signUpButton;

    @FindBy(xpath = "//h3[@class='RTL']")
    public static WebElement successMessage;

    public void userRegistration(String firstName, String lastName, String mobileNumber,String email, String password, String confirmPassword) throws InterruptedException {
        typeText(firstNameField, firstName);

        typeText(lastNameFiled, lastName);

        typeText(mobileNumberFiled,mobileNumber);

        typeText(emailField, email);

        typeText(passwordField, password);

        typeText(confirmPasswordFiled, confirmPassword);

        scrollIntoView(signUpButton);
        clickButton(signUpButton);
    }
}
