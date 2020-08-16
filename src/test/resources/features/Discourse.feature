@test
Feature: Discourse test

  @discourse
  Scenario: Print description of locked topics, items of each category and most viewed topic
    Given I open Discourse main page
    When I click on the Demo option in the main menu
    And I scroll until the end of the page
    Then I should print the description of all locked topics
    And I should print the number of items of each category
    And I should print the title of the topic with more views
