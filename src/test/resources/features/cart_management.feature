Feature: Cart Management Functionality for Shopping Cart Application
  As a user of application
  I want to Browse and add items to cart for check out


  Scenario Outline: Successfully Adding of an Item to the Cart
    Given I want to add items to the cart
    When I click on Add Item to Cart button for "<item>"
    Then I should be able to see the added "<item>" at the cart page

    Examples:
      | item     |  |
      | Carrot   |  |
      | Beetroot |  |

