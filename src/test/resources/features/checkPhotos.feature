Feature: Check the photos whether broken or not

  @wip
  Scenario Outline: Verify that all photos give 200 status code after clicking
    Given user on the "imdbPage" page
    When user search "<movieName>"
    And user clicks "<movieName>" from search results
    And user clicks Photos under movie information
    Then verify that all photos return 200 status code
    Examples:
      | movieName       |
      | The Circus      |
      | The Jazz Singer |