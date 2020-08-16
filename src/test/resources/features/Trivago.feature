@test
Feature: Trivago test

  @trivago
  Scenario: Print information from hotel after search
    Given I open Trivago main page
    When I search for "Natal" in the search field
    And I set the guest configuration as single room
    And I sort the results by distance only
    Then I should print the second hotel name
    And I should print the number of the hotel stars
    And I should print the name of the offer site
    And I should print the room price
    And I should print all room amenities


