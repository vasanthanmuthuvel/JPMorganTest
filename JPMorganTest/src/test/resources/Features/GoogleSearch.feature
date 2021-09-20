@JPMorgan
Feature: Googke Search
  I want to use this feature to test Google search of JP Morgan

  @JPMorgan
  Scenario Outline: Search J.P.Morgan
    Given Im on the Google Home Page
    And type <word> in the Google Search text box
    When I hit enter
    Then I Should see Google Search Results
    And I click First Result
    Then I should See J.P.Morgan logo

    Examples: 
      | word  |
      | J.P.Morgan |