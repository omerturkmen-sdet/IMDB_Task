Feature: Comparing Movie Cast Information

  @wip
  Scenario Outline: Verify that movie information doesn't change based on navigating options
    Given user on the "imdbPage" page
    When user clicks Menu button
    And user clicks "Oscars" under "Awards & Events"
    And user clicks "1929" under Event History
    And user clicks "<movieName>" from "Honorary Award" category
    And information about the film will be saved
    And take screenshot for first navigating option "<screenshotName1>"
    And user navigates to home page
    When user search "<movieName>"
    And user clicks "<movieName>" from search results
    Then verify that information about the movie is matching
    And take screenshot for second navigating option "<screenshotName2>"
    Examples:
      | movieName       | screenshotName1                      | screenshotName2                         |
      | The Circus      | The Circus_NavigatingFromAwards      | The Circus_NavigatingFromSearchBox      |
      | The Jazz Singer | The Jazz Singer_NavigatingFromAwards | The Jazz Singer_NavigatingFromSearchBox |