Feature:Buy item after login

  Scenario Outline: Buy new item
    Given User is logged Mystore
    When User goes to PrintedSweaterPage
    And User adds and saves <size> and <quantity>
    And User add item to cart and buy it
    Then Make a screenshot of payment

    Examples:
      | size | quantity |
      | L    | 1        |