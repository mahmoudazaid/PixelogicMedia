package extnstions;

import browser.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementExtensions {

    public static void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void waitUntilElementDisplayed(WebElement locator,int timeoutInSeconds){
        new WebDriverWait(Driver.driver, timeoutInSeconds).until(ExpectedConditions.visibilityOf(locator));
    }
}
