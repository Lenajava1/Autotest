@converter
Feature: Converter functions

  @converter1
  Scenario Outline: Validate Fahrenheit to Celsius
    Given I go to "converter" page
    When I click on <Tab>
    And I set <From> to <To>
    Then I enter into From field <value> and verify <result> result
    Then convert to outline with the following values:
    Examples:
    | Tab           | From         | To         | value | result |
    | "Temperature" | "Fahrenheit" | "Celsius"  | "54"  | "12.2" |
    | "Weight"      |  "Pound"     | "Kilogram" | "170" | "77"   |
    | "Length"      |  "Mile"      | "Kilometer"| "50"  | "80.4" |