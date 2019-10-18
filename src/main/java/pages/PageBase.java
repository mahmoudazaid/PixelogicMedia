package pages;

import browser.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

//    protected WebDriver driver;

    //Create Constructor
    public PageBase(WebDriver driver) {
        PageFactory.initElements(Driver.driver, this);
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

    public static void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void waitUntilElementDisplayed(WebElement locator,int timeoutInSeconds){
        new WebDriverWait(Driver.driver, timeoutInSeconds).until(ExpectedConditions.visibilityOf(locator));
    }
}
