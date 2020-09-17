Feature:


  Background:
    Given I am on Github home page
    And Click on SignIn button

  @Smoke
  Scenario: Editing the profile
    Given I click on Your Profile option
    When I click on edit profile button
    And Uploaded new picture
    Then I should be seeing new profile picture

  @Regression @Everytime
  Scenario: Create new gist
    Given I click on Your Gists option
    When I provide filename, description
    And click on Create public gist method
