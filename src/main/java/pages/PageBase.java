package pages;

import browser.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static extnstions.ElementExtensions.scrollIntoView;
import static extnstions.ElementExtensions.waitUntilElementDisplayed;

public class PageBase extends Driver {

//    protected static WebDriver driver;

    //Create Constructor
    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static void clickButton(WebElement button) {
        waitUntilElementDisplayed(button,5);
        scrollIntoView(button);
        button.click();
    }

    public static void getText(WebElement element){
        element.getText();
    }

    public static void typeText(WebElement element, String text) {
        scrollIntoView(element);
        element.clear();
        element.sendKeys(text);
    }

}