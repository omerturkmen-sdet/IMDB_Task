package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "home_img_holder")
    public WebElement navigateHomePageBtn;

    @FindBy(xpath = "//div[@class='ipc-button__text'][text()='Menu']")
    public WebElement menuBtn;

    @FindBy(id = "suggestion-search")
    public WebElement searchBox;

    public void navigateToCategoryUnderMenu(String categoryHeader, String module){
        String locatorToNavigate = "//span[text()='"+categoryHeader+"']/../../..//div//span[text()='"+module+"']";
        BrowserUtils.waitForClickability(By.xpath(locatorToNavigate),5);
        Driver.get().findElement(By.xpath(locatorToNavigate)).click();
    }

    public void selectFromSearchResults(String movie){
        String locatorForMovieFromSearchResult = "//div[contains(@class,'searchResult__constTitle')][text()='"+movie+"']";
        BrowserUtils.waitForClickability(By.xpath(locatorForMovieFromSearchResult),5);
        Driver.get().findElement(By.xpath(locatorForMovieFromSearchResult)).click();
    }
}
