package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[contains(text(),'My Account')]")
    WebElement myAccount;

    @FindBy(xpath = "(//a[contains(text(),'Sign Up')])[2]")
    WebElement signUpLink;

        @FindBy(xpath="(//a[contains(text(),'Login')])[2]")
    WebElement login;

    public void openRegistrationPage(){
        clickButton(myAccount);
        clickButton(signUpLink);
    }

    public void openLoginPage(){
        clickButton(myAccount);
        clickButton(login);
    }
}
