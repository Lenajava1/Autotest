@careers
  Feature: Careers

    @careers1 @post_position @clean_position
    Scenario: Updating positions via UI
      Given I go to "careers" page oop
      And I login as a "recruiter"
      And I update "automation" position
      Then I verify "automation" position is updated
