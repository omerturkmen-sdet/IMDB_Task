package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BrowserUtils;
import utilities.Driver;

public class AwardsPage extends BasePage{

    /**
     * Dynamic method for selecting any movie with specific category name
     * @param category
     * @param movieName
     */
    public void clickMovieUnderAwardCategory(String category,String movieName){
        String movieLocator = "//div[text()='"+category+"']/..//a[text()='"+movieName+"']";
        WebElement movie = Driver.get().findElement(By.xpath(movieLocator));
        BrowserUtils.scrollToElement(movie);
        movie.click();
    }
}
