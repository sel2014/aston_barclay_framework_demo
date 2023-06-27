Feature: Searching for and Viewing Vehicles
  As a user
  I want to be able to search for and view available vehicles
  So that I can easily find the information I need


#  @wip
  Scenario: Searching for Vehicles
    Given I am on the Aston Barclay homepage
    When I enter "Tesla" into the search bar
    And I click on the search button
    Then I should be directed to a search results page
    And the page should display a list of available Tesla vehicles



