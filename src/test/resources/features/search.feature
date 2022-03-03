@wip
Feature: Search Test

  Scenario: Sign In With Email
    Given User will navigate to HomePage
    When User is on the home page
    Then User will see searchbox
    When User will type "Stainless work table"
    And User will click on search button
    Then User will verify every product item has the word "Table" in its title.
    And user wiil add last found item on the cart
    Then user will empty the cart



