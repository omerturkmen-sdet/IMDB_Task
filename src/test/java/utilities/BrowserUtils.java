package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    /**
     * Convert List of WebElement to List of String by using getText() method
     * @param listOfWebElement
     * @return
     */
    public static List<String> getElementTextsAsList(List<WebElement> listOfWebElement){

        List<String> elementTexts = new ArrayList<>();

        for (WebElement webElement : listOfWebElement) {
            elementTexts.add(webElement.getText());
        }
        return elementTexts;
    }

    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for given element to be clickable
     * @param element
     * @param timeout
     */
    public static void waitForClickability(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.get(),timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for given element to be clickable by using locator
     * @param locator
     * @param timeout
     */
    public static void waitForClickability(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.get(),timeout);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void takeScreenshot(String screenshotName){
        TakesScreenshot screenshot = (TakesScreenshot)Driver.get();
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/"+screenshotName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
