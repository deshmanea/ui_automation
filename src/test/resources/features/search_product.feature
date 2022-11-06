Feature: Product details validation
 Scenario: Validate user is able to view product details under 'About this item'

   Given User select "TV, Appliances, Electronics" menu with "Television" submenu
   When User filter result with "Samsung" brand
   And Filter result by price high to low, select "2" result
   Then User should be able to see "About this item"


  Scenario: Validate user is able to view product details under 'About this item'

    Given User select "TV, Appliances, Electronics" menu with "Television" submenu
    When User filter result with "Samsung" brand
    And Filter result by price high to low, select "2" result
    Then User should be able to see "About this item"