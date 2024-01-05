@usps

Feature: Usps Scenarios

  #Background: Opening Usps page
    #Given I go to "usps" page

  @usps1
  Scenario Outline: Validate ZIP code
    Given I go to "usps" page
    When I navigate to Look Up a ZIP Code by Address
    And I fill out "<street>" street, "<city>" city, "<state>" state
    And I wait for 2 sec
    And I submit ZIP Code by Address form
    Then I validate "<zip>" zip code is present in result
    Examples:
      | street              | city     | state | zip   |
      | 4970 El Camino Real | Los Altos|  CA   | 94822 |
      | 20 Broad st         | New York |  NY   | 10005 |
      | 440 S. LaSalle st   | Chicago  |  IL   | 60605 |

  @usps2
  Scenario: Calculate price
    Given I go to "usps" page
    When I go to Calculate Price Page
    And I select "Canada" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.90"

  @usps3
  Scenario: Verify location
    #Given I go to "usps" page
    When I perform "Free Boxes" search
    And I set "Send" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now" button
    Then I validate that Sign In is required

    @usps4
    Scenario: Javascript
      Given I go to "ups" page
      And I select a region

  @usps5
  Scenario: Every door direct mail
    Given I go to "usps" page
    When I go to "Every Door Direct Mail" under "Business"
    And I wait for 3 sec
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    And I choose view as "Table" on the map
    When I select all in the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary



