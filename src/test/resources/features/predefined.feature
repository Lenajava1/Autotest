@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"


    @predefined3
    Scenario: Predefined steps for Yahoo
      Given I open url "https://www.yahoo.com"
      Then element with xpath "//button[@class='btn primary']" should be present
      When I click on element with xpath "//button[@class='btn primary']"
      Then I should see page title as "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos"
      Then element with xpath "//input[@name='p']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='p']"
      Then I click on element with xpath "//button[@type='submit']"
      And I wait for element with xpath "//ol[@class=' reg searchCenterMiddle']" to be present
      Then element with xpath "//ol[@class=' reg searchCenterMiddle']" should contain text "Cucumber"

      
      @predefined4
      Scenario: Predefined steps for Gibiru
        Given I open url "https://gibiru.com"
        Then I should see page title contains "Gibiru"
        Then element with xpath "//input[@name='q']" should be present
        When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
        Then I click on element with xpath "//button[@type='submit']"
        Then I wait for element with xpath "//*[@class='gsc-control-cse gsc-control-cse-en']" to be present
        Then element with xpath "//*[@class='gsc-control-cse gsc-control-cse-en']" should contain text "Behavior"



  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com"
    Then I should see page title contains "DuckDuckGo"
    And element with xpath "//input[@id='searchbox_input']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='searchbox_input']"
    Then I click on element with xpath "//button[@type='submit']"
    And I wait for element with xpath "//*[@class='results--main']" to be present
    Then element with xpath "//*[@class='results--main']" should contain text "Behavior"

  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com/en"
    Then I should see page title contains "Swisscows"
    And element with xpath "//input[@class='input-search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@class='input-search']"
    Then I click on element with xpath "//button[@class='search-submit']"
    And I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Search Encrypt
    Given I open url "https://www.searchencrypt.com/home"
    Then I should see page title contains "Search Encrypt"
    And element with xpath "//input[@class='search-bar__search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@class='search-bar__search']"
    Then I click on element with xpath "//button[@class='search-bar__submit']"
    And I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "BDD"


  @predefined8
  Scenario: Predefined steps for Start Page
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//input[@id='q']/..//button"
    Then I wait for element with xpath "//section[@class='w-gl w-gl--desktop w-gl--']" to be present
    Then element with xpath "//section[@class='w-gl w-gl--desktop w-gl--']" should contain text "BDD"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://yandex.com"
    Then I should see page title contains "Yandex"
    And element with xpath "//input[@name='text']" should be present
    Then I click on element using JavaScript with xpath "//button[@data-id='button-all']"
    When I type "BDD" into element with xpath "//input[@name='text']"
    Then I click on element with xpath "//span[contains(text(),'Search')]/.."
    And I wait for 3 sec
    Then I click on element using JavaScript with xpath "//div[@class='CheckboxCaptcha-Checkbox']"
    And I wait for 3 sec
    Then element with xpath "//input[@name='text']" should be present


  @predefined10
  Scenario: Predefined steps for Boardreader
    Given I open url "https://boardreader.com"
    Then I should see page title contains "Boardreader"
    And element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    Then I click on element with xpath "//button[@id='title-submit']"
    Then I wait for 2 sec
    And I wait for element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" to be present
    Then element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" should contain text "Cucumber"


  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org"
    Then I should see page title contains "Ecosia"
    And I click on element with xpath "//button[@data-test-id='cookie-notice-accept']"
    Then I wait for 3 sec
    And element with xpath "//input[@data-test-id='search-form-input']" should be present
    When I type "BDD" into element with xpath "//input[@data-test-id='search-form-input']"
    Then I click on element with xpath "//button[@data-test-id='search-form-submit']"
    And I wait for 3 sec
    Then I click on element with xpath "//section[@data-test-id='mainline']"
    And element with xpath "//section[@data-test-id='mainline']" should contain text "Cucumber"
    


    @predefined12 @market @smoke
      Scenario: Validate responsive UI
      Given I open url "https://skryabin.com/market/quote.html"
      When I resize window to 993 and 1200
      Then element with xpath "//b[@id='location']" should be displayed
      And element with xpath "//b[@id='currentDate']" should be displayed
      Then element with xpath "//b[@id='currentTime']" should be displayed
      And I wait for 2 sec
      When I resize window to 768 and 1200
      Then element with xpath "//b[@id='location']" should not be displayed
      Then element with xpath "//b[@id='currentDate']" should not be displayed
      Then element with xpath "//b[@id='currentTime']" should not be displayed
      And I wait for 2 sec
      When I resize window to 767 and 1200
      Then element with xpath "//b[@id='location']" should not be displayed
      And element with xpath "//b[@id='currentDate']" should not be displayed
      Then element with xpath "//b[@id='currentTime']" should not be displayed
      And I wait for 2 sec


      @predefined13 @smoke @market

        Scenario: Fill out and validate “Username” field
        Given I open url "https://skryabin.com/market/quote.html"
        Then element with xpath "//input[@name='username']" should be present
        When I type "d" into element with xpath "//input[@name='username']"
        Then I click on element with xpath "//label[@for='username'][@class='required']"
        And I wait for 1 sec
        Then element with xpath "//label[@id='username-error']" should have text as "Please enter at least 2 characters."
        When I type "o" into element with xpath "//input[@name='username']"
        Then I wait for 1 sec
        And element with xpath "//label[@id='username-error']" should not be displayed


        @predefined14 @smoke @market

          Scenario: Validate “Email” field behavior
          Given I open url "https://skryabin.com/market/quote.html"
          Then element with xpath "//input[@name='email']" should be present
          When I type "lenapost.com" into element with xpath "//input[@name='email']"
          Then I click on element with xpath "//label[@for='email'][@class='required']"
          And I wait for 1 sec
          Then element with xpath "//label[@id='email-error']" should have text as "Please enter a valid email address."
          When I clear element with xpath "//input[@name='email']"
          When I type "lenapost@" into element with xpath "//input[@name='email']"
          Then I click on element with xpath "//label[@for='email'][@class='required']"
          And I wait for 1 sec
          Then element with xpath "//label[@id='email-error']" should have text as "Please enter a valid email address."
          When I clear element with xpath "//input[@name='email']"
          When I type "@mail.com" into element with xpath "//input[@name='email']"
          Then I click on element with xpath "//label[@for='email'][@class='required']"
          And I wait for 1 sec
          Then element with xpath "//label[@id='email-error']" should have text as "Please enter a valid email address."
          When I clear element with xpath "//input[@name='email']"
          When I type "lenapost@mail.com" into element with xpath "//input[@name='email']"
          Then I wait for 1 sec
          And element with xpath "//label[@id='email-error']" should not be displayed

          @predefined15 @smoke
            Scenario: Fill out and validate “Password” set of fields
            Given I open url "https://skryabin.com/market/quote.html"
            Then element with xpath "//input[@name='password']" should be present
            And element with xpath "//input[@name='confirmPassword']" should be present
            When I click on element with xpath "//input[@name='password']"
            Then element with xpath "//input[@name='confirmPassword']" should be disabled
            When I type "1234" into element with xpath "//input[@name='password']"
            When I click on element with xpath "//label[@class='required'][@for='password']"
            Then element with xpath "//label[@id='password-error']" should have text as "Please enter at least 5 characters."
            And element with xpath "//input[@name='confirmPassword']" should be enabled
            When I type "abcdefg" into element with xpath "//input[@name='confirmPassword']"
            Then I click on element with xpath "//label[@for='confirmPassword'][@class='required']"
            And element with xpath "//label[@id='confirmPassword-error']" should have text as "Passwords do not match!"
            When I clear element with xpath "//input[@name='confirmPassword']"
            When I type "1234" into element with xpath "//input[@name='confirmPassword']"
            Then I click on element with xpath "//label[@for='confirmPassword'][@class='required']"
            And element with xpath "//label[@id='confirmPassword-error']" should have text as "Please enter at least 5 characters."
            When I type "5" into element with xpath "//input[@name='password']"
            Then element with xpath "//label[@id='password-error']" should not be displayed
            When I type "5" into element with xpath "//input[@name='confirmPassword']"
            Then element with xpath "//label[@id='confirmPassword-error']" should not be displayed

            @predefined16 @smoke
              Scenario: Validate “Name” field behavior
              Given I open url "https://skryabin.com/market/quote.html"
              Then element with xpath "//input[@id='name']" should be present
              When I click on element with xpath "//input[@id='name']"
              Then element with xpath "//div[@aria-describedby='nameDialog']" should be displayed
              When I type "Elena" into element with xpath "//input[@id='firstName']"
              When I type "Evgenyevna" into element with xpath "//input[@id='middleName']"
              When I type "Mutykova" into element with xpath "//input[@id='lastName']"
              When I click on element with xpath "//span[contains(text(), 'Save')]/."
              Then element with xpath "//div[@aria-describedby='nameDialog']" should not be displayed
              And element with xpath "//input[@id='name']" should have attribute "value" as "Elena Evgenyevna Mutykova"

              @predefined17 @smoke
                Scenario: Validate that Accepting Privacy Policy is required to
              submit the form, then check the field.
                Given I open url "https://skryabin.com/market/quote.html"
                When I click on element with xpath "//button[@id='formSubmit']"
                And I wait for 2 sec
                Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "Must check!"
                When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
                Then element with xpath "//input[@name='agreedToPrivacyPolicy']" should be selected
                And element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed

                @predefined18 @smoke
                  Scenario: Try entering the following non-required fields in the order:
                • Phone Number
                • Country of Origin
                • Gender
                • Allowed to Contact?
                • Address
                • Car Make
                • 3rd party agreement acceptance
                • Date of Birth

                  Given I open url "https://skryabin.com/market/quote.html"
                  Then I wait for 3 sec
                  When I type "+1213232424" into element with xpath "//input[@name='phone']"
                  When I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Russia']"
                  When I click on element with xpath "//input[@name='gender'][@value='female']"
                  When I click on element with xpath "//input[@name='allowedToContact']"
                  When I type "2344 Budapest Andrassy 122, 2/A" into element with xpath "//textarea[@id='address']"
                  When I click on element with xpath "//select[@name='carMake']/option[@value='BMW']"
                  When I click on element with xpath "//button[@onclick='thirdPartyAlert()']"
                  Then I wait for 3 sec

                  And element with xpath "//input[@id='thirdPartyAgreement']" should have attribute "value" as "accepted"
                  When I click on element with xpath "//input[@id='dateOfBirth']"
                  Then element with xpath "//div[@id='ui-datepicker-div']" should be displayed
                  When I click on element with xpath "//select[@data-handler='selectMonth']/option[@value='2']"
                  When I click on element with xpath "//select[@data-handler='selectYear']/option[@value='1993']"
                  When I click on element with xpath "//a[contains(text(),'16')]"
                  Then I wait for 3 sec

                  @predefined19 @smoke
                    Scenario: Submit the form and verify the data.
                  Validate that after form submission entered fields
                  values are present on the page.
                  Validate that password is not displayed on the page

                    Given I open url "https://skryabin.com/market/quote.html"
                    Then I wait for 3 sec
                    When I type "lenapost@mail.com" into element with xpath "//input[@name='email']"
                    When I type "lena001" into element with xpath "//input[@name='username']"
                    When I click on element with xpath "//input[@id='name']"
                    Then element with xpath "//div[@aria-describedby='nameDialog']" should be displayed
                    When I type "Elena" into element with xpath "//input[@id='firstName']"
                    When I type "Evgenyevna" into element with xpath "//input[@id='middleName']"
                    When I type "Mutykova" into element with xpath "//input[@id='lastName']"
                    When I click on element with xpath "//span[contains(text(), 'Save')]/."
                    When I type "+1213232424" into element with xpath "//input[@name='phone']"
                    When I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Russia']"
                    When I click on element with xpath "//input[@name='gender'][@value='female']"
                    When I click on element with xpath "//input[@name='allowedToContact']"
                    When I type "2344 Budapest Andrassy 122, 2/A" into element with xpath "//textarea[@id='address']"
                    When I click on element with xpath "//select[@name='carMake']/option[@value='BMW']"
                    When I click on element with xpath "//button[@onclick='thirdPartyAlert()']"
                    Then I wait for 3 sec
                    Then element with xpath "//input[@id='thirdPartyAgreement']" should have attribute "value" as "accepted"
                    When I click on element with xpath "//input[@id='dateOfBirth']"
                    Then element with xpath "//div[@id='ui-datepicker-div']" should be displayed
                    When I click on element with xpath "//select[@data-handler='selectMonth']/option[@value='2']"
                    When I click on element with xpath "//select[@data-handler='selectYear']/option[@value='1993']"
                    When I click on element with xpath "//a[contains(text(),'16')]"
                    Then I wait for 2 sec
                    When I click on element with xpath "//button[@id='formSubmit']"
                    Then element with xpath "//label[@id='password-error'][contains(text(),'This field is required.')]" should be displayed
                    And element with xpath "//div[@id='quotePageResult']" should be present
                    And element with xpath "//b[@name='password']" should not be displayed
                    And element with xpath "//b[@name='name']" should have text as "Elena Evgenyevna Mutykova"
                    And element with xpath "//legend/../section" should have text as "1213232424"
                    And element with xpath "//b[@name='username'][contains(text(),'lena001')]" should be present
                    And element with xpath "//b[@name='email'][contains(text(),'lenapost@mail.com')]" should be present
                    And element with xpath "//b[@name='dateOfBirth'][contains(text(),'03/16/1993')]" should be present
                    And element with xpath "//b[@name='countryOfOrigin'][contains(text(),'Russia')]" should be present
                    And element with xpath "//b[@name='gender'][contains(text(),'female')]" should be present
                    And element with xpath "//b[@name='address'][contains(text(),'2344 Budapest Andrassy 122, 2/A')]" should be present
                    And element with xpath "//b[@name='carMake'][contains(text(),'BMW')]" should be present
                    And element with xpath "//b[@name='allowedToContact'][contains(text(),'true')]" should be present
                    Then I wait for 2 sec




                  










