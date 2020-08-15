@test
Feature: Channels actions

  @discourse
  Scenario: Subscribe to a channel
    Given I open the discourse main page
    When I click in the Demo option in the main menu
    And I scroll until the end of the page
    Then I should print the description of all locked topics
    And I should print the number of items of each category
    And I should print the title of the topic with more views
