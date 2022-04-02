package pages;

import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.*;

public class PhotoGalleryPage extends BasePage{

    @FindBy(xpath = "//*[@id='media_index_thumbnail_grid']//img")
    public List<WebElement> images;

    /**
     * In html code, image have url in the 'src' attribute.
     * It will get all the url and store in a List
     * @return
     */
    public List<String> gettingAllPhotosUrl(){
        List<String> photosUrlList = new ArrayList<>();

        for (WebElement image : images) {
            photosUrlList.add(image.getAttribute("src"));
        }

        //Surrounded by try catch to prevent exception if there is no 'Next' button
        try {
            //Click 'Next' to get photos from next page
           Driver.get().findElement(By.xpath("//a[contains(text(),'Next')]")).click();

            for (WebElement image : images) {
                photosUrlList.add(image.getAttribute("src"));
            }
        }catch (Exception e){}

        return photosUrlList;
    }

    /**
     * It will check if there is any broken image or not
     * @param statusCode
     * @return
     */
    public boolean arePhotosLinkBroken(int statusCode){
        boolean flag = true;
        for (String url : gettingAllPhotosUrl()) {
            if (!checkStatusCode(url,statusCode))
                flag = false;
        }
        return flag;
    }

    /**
     * Send request with REST Assured and check the status code
     * @param url
     * @param expectedStatusCode
     * @return
     */
    public boolean checkStatusCode(String url,int expectedStatusCode){
        Response response = when().get(url);
        return (response.statusCode()==expectedStatusCode);
    }

}
