package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AwardsPage;
import pages.HomePage;
import pages.MovieInfoPage;
import pages.OscarsPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;
import java.util.Set;
import static utilities.BrowserUtils.*;

public class ComparingInformationStepDefs {

    HomePage homePage = new HomePage();
    MovieInfoPage movieInfoPage = new MovieInfoPage();
    Map<String, List<String>> movieInfoByNavigatingFromAwardPage;
    Map<String, List<String>> movieInfoBySearching;


    @Given("user on the {string} page")
    public void user_on_the_page(String pageName) {
        //Driver.get().get("https://www.imdb.com/");
        Driver.get().get(ConfigurationReader.get(pageName));
    }

    @When("user clicks Menu button")
    public void user_clicks_Menu_button() {
        homePage.menuBtn.click();
    }

    @When("user clicks {string} under {string}")
    public void user_clicks_under(String module, String categoryHeader){
        homePage.navigateToCategoryUnderMenu(categoryHeader,module);
    }

    @When("user clicks {string} under Event History")
    public void user_clicks_under_Event_History(String year) {
        new OscarsPage().navigateSelectedEventHistory(year);
    }

    @When("user clicks {string} from {string} category")
    public void user_clicks_from_category(String movie, String category) {
        new AwardsPage().clickMovieUnderAwardCategory(category,movie);
    }

    @When("information about the film will be saved")
    public void information_about_the_film_will_be_saved() {
        movieInfoByNavigatingFromAwardPage = movieInfoPage.getCastInfo();
    }

    @When("take screenshot for first navigating option {string}")
    public void take_screenshot_for_first_navigating_option(String screenshotName) {
        scrollToElement(movieInfoPage.castInfoElement);
        takeScreenshot(screenshotName);
    }

    @When("user navigates to home page")
    public void user_navigates_to_home_page() {
        homePage.navigateHomePageBtn.click();
    }

    @When("user search {string}")
    public void user_search(String stringForSearch) {
        homePage.searchBox.sendKeys(stringForSearch);
    }

    @When("user clicks {string} from search results")
    public void user_clicks_from_search_results(String movie) {
        homePage.selectFromSearchResults(movie);
    }

    @Then("verify that information about the movie is matching")
    public void verify_that_information_about_the_movie_is_matching() {
        movieInfoBySearching = movieInfoPage.getCastInfo();
        Assert.assertEquals(movieInfoByNavigatingFromAwardPage,movieInfoBySearching);
    }



    @Then("take screenshot for second navigating option {string}")
    public void take_screenshot_for_second_navigating_option(String screenshotName) {
        scrollToElement(movieInfoPage.castInfoElement);
        takeScreenshot(screenshotName);
    }
}
