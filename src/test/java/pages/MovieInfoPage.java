package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MovieInfoPage extends BasePage{

    @FindBy(xpath = "//h3[text()='Photos']")
    public WebElement photosLink;

    @FindBy(css = ".sc-fa02f843-0.fjLeDR")
    public WebElement castInfoElement;

    /**
     * There is some problem with the information title. The Circus has "Writer" title, but The Jazz Singer has "Writers" title
     * So I locate the title first and get information dynamically and store them in Key & Value format
     * @return
     */
    public Map<String, List<String>> getCastInfo(){
        Map<String, List<String>> movieInfoMap = new HashMap<>();

        //Locating Director name or Directors names
        String locatorForDirector = "(//div[@role='presentation']/ul[@role='presentation'])[2]/li[1]/span";
        String directorTitle = Driver.get().findElement(By.xpath(locatorForDirector)).getText();
        List<String> directorNameList = BrowserUtils.getElementTextsAsList(Driver.get().findElements(By.xpath(locatorForDirector + "/..//a")));

        //Locating Writer name or Writers names
        String locatorForWriters = "(//div[@role='presentation']/ul[@role='presentation'])[2]/li[2]/span";
        String writerTitle = Driver.get().findElement(By.xpath(locatorForWriters)).getText();
        List<String> writerNameList = BrowserUtils.getElementTextsAsList(Driver.get().findElements(By.xpath(locatorForWriters + "/..//a")));

        //Locating Star name or Stars names
        String locatorForStars = "(//div[@role='presentation']/ul[@role='presentation'])[2]/li[3]/a";
        String starTitle = Driver.get().findElement(By.xpath(locatorForStars)).getText();
        List<String> starNameList = BrowserUtils.getElementTextsAsList(Driver.get().findElements(By.xpath(locatorForStars + "/../div//a")));

        movieInfoMap.put("Director(s)",directorNameList);
        movieInfoMap.put("Writer(s)",writerNameList);
        movieInfoMap.put("Star(s)",starNameList);

        return movieInfoMap;
    }



}
