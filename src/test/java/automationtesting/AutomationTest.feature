Feature: Steps Functionality

  Scenario: Asserting Thinking in HTML book existence along with its price
    Given I open the website
    Then I check the book "Thinking in HTML" availability
    And I should see the price "₹400.00"

  Scenario: Clicking on Add to Basket for Thinking in HTML book
    Given I open the website
    When I add the book "Thinking in HTML" to the basket
    Then I should see the book in the basket

  Scenario: Clicking on Shopping Cart
    Given I open the website
    When I add the book "Thinking in HTML" to the basket
    And I click on the shopping cart

  Scenario: Clicking on Proceed to Checkout
    Given I open the website
    When I add the book "Thinking in HTML" to the basket
    And I click on the shopping cart
    And I click on proceed to checkout
    Then billing details form should be displayed
