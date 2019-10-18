package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends PageBase {
    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//a[contains(text(),' Logout')])[2]")
    public static WebElement logoutButton;

    @FindBy(xpath = "(//a[@class='dropdown-toggle go-text-right'])[3]")
    WebElement userAccount;

    public void logOut(){
        clickButton(userAccount);
        clickButton(logoutButton);
    }
}
