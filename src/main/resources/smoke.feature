Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks wish list on first product
    And User opens Wish List
    Then User checks that amount of products in wish list are '<amountOfProducts>'

    Examples:
      | homePage                            | keyword | amountOfProducts |
      | https://www.asos.com/women/         | cake    | 1 item          |
      | https://www.asos.com/women/         | cake    | 1 item          |
      | https://www.asos.com/women/         | cake    | 1 item          |

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks search field visibility
    And User checks cart visibility
    And User checks register button visibility
    And User checks sign in dropdown visibility
    When User opens 'Sign In' dropdown
    And User checks 'Sign In' visibility on 'Sign In' dropdown
    And User opens shopping cart
    Then User checks that shopping cart title visible


    Examples:
      | homePage                            |
      | https://www.asos.com/women/         |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks 'Add to Cart' button on product
    And User checks that add to cart popup visible
    And User checks 'Continue to Cart' button visibility
    Then User checks that add to cart popup header is '<header>'
    And User clicks 'Continue to Cart' button
    And User clicks 'Checkout' button
    And User checks 'Sign in' screen visibility

    Examples:
      | homePage                            | keyword        | header          |
      | https://www.asos.com/women/         | chicken nugget | My Bag,1 item   |

