Feature: User selects the first book from the search results for Appium Book
# The first scenarios has two steps
  Scenario: User shops for a Appium Book
    Given User is on the "https://www.amazon.com" search page
    When User searches for "Appium Book"
    Then User selects the first search result with some rating details
    And User adds the book to the cart
    And close browsers

