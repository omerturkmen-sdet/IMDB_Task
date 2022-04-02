package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class OscarsPage extends BasePage{
    /**
     * Selecting award year from event history
     * @param year
     */
    public void navigateSelectedEventHistory(String year){
        String locatorForEventHistoryYear = "//div[@class='event-history-widget__years']//a[text()='"+year+"']";
        Driver.get().findElement(By.xpath(locatorForEventHistoryYear)).click();
    }
}
