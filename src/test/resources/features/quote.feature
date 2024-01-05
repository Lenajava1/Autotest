@quote
Feature: Quote project

  @quote1
  Scenario: Quote basic test
      #Given I go to "bing" page
    Given I go to "quote" page
      #And I print page details
    When I fill out required fields
    When I fill out optional fields
    And I switch to iframe, alert and new window
    And I submit the form
    Then I verify fields saved correctly
      #And I go back and forward, then refresh the page
      #And I print logs to the console
      #And I change resolution to phone
      #And I change resolution to desktop

  @quote1oop
  Scenario: Quote basic test oop
    Given I go to "quote" page oop
    When I fill out required fields oop
    When I fill out optional fields oop
    And I submit the form oop
    Then I verify fields saved correctly oop


  @quote2oop
  Scenario: Quote basic label required oop
    Given I go to "quote" page oop
    Then label "Username" has required asterisk
    Then label "Email" has required asterisk
    Then label "Password" has required asterisk
    Then label "Confirm Password" has required asterisk
    Then label "Gender" is not required asterisk

  @quote2
  Scenario: Switching to alerts
    #Given I go to "quote" page
   # When I "accept" third party agreement
    #And I verify third party agreement "accepted"

  @quote3oop
  Scenario: Switching to iframe oop
    Given I go to "quote" page
   When I pass "Anna" and phone number "23242435325" oop
   And I submit the form oop

  @quote4
  Scenario: I switching to window
   # Given I go to "quote" page
    #When I open related documents
    #And I verify "Document 2"

  @quote5
  Scenario: Required fields test
    Given I go to "quote" page
    Then I don't see "username" error message
    And I don't see "email" error message
    And I don't see "password" error message
    And I don't see "name" error message
    And I don't see "agreedToPrivacyPolicy" error message
    And I submit the form
    Then I see "username" error message "This field is required."
    And I see "email" error message "This field is required."
    And I see "password" error message "This field is required."
    And I see "name" error message "This field is required."
    And I see "agreedToPrivacyPolicy" error message "- Must check!"


  @quote6
  Scenario: Market username test
    Given I go to "quote" page
    When I fill out "username" field with "a"
    And I submit the form
    Then I see "username" error message "Please enter at least 2 characters."
    When I fill out "username" field with "ab"
    Then I don't see "username" error message

  @quote7
  Scenario: Market email test
    Given I go to "quote" page
    When I fill out "email" field with "john"
    And I submit the form
    Then I see "email" error message "Please enter a valid email address."
    When I fill out "email" field with "john@example.com"
    Then I don't see "email" error message


  @quote8
  Scenario: Market passwords test
    Given I go to "quote" page
    When I fill out "password" field with "1234"
    And I submit the form
    Then I see "password" error message "Please enter at least 5 characters."
    When I fill out "password" field with "12345"
    Then I don't see "password" error message
    When I fill out "confirmPassword" field with "1234"
    And I submit the form
    Then I see "confirmPassword" error message "Please enter at least 5 characters."
    When I fill out "confirmPassword" field with "54321"
    Then I see "confirmPassword" error message "Passwords do not match!"
    When I fill out "confirmPassword" field with "12345"
    Then I don't see "confirmPassword" error message





      