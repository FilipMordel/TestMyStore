Feature: Add new address after login

  Scenario Outline: Add new address
    Given User logged at MyStore
    When User goes to UserAddressPage
    And User crates new address
    And User adds and saves <alias>, <address>, <city>, <zip/postal code>, <country> and <phone>
    Then User gets "Address successfully added!"
    And User deletes address
    Then User deleted address and gets "Address successfully deleted!"
    Examples:
      | alias | address    | city    | zip/postal code | country        | phone     |
      | Jogi  | Powstancow | Wroclaw | 51-925          | United Kingdom | 500600800 |
