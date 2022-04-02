package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.MovieInfoPage;
import pages.PhotoGalleryPage;

public class CheckingPhotoResponseStepDefs {

    @When("user clicks Photos under movie information")
    public void user_clicks_Photos_under_movie_information() {
        new MovieInfoPage().photosLink.click();
    }

    @Then("verify that all photos return {int} status code")
    public void verify_that_all_photos_return_status_code(int expectedStatusCode) {
        Assert.assertTrue(new PhotoGalleryPage().arePhotosLinkBroken(expectedStatusCode));
    }

}
