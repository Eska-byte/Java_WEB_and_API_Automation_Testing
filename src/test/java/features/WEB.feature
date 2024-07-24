Feature: Login - Checkout

  @WEB
  Scenario: Login with valid username and password (positive)
    Given user is on login page
    When user input username textbox with "standard_user"
    And user input password textbox with "secret_sauce"
    And user click login button
    Then user will direct to homepage

  @WEB
  Scenario: Login with invalid username and/or password (negative)
    Given user is on login page
    When user input username textbox with "standard_user"
    And user input password textbox with "secret_sauces"
    And user click login button
    Then user will see error message "do not match "

  @WEB
  Scenario: Login without username and/or password (negative)
    Given user is on login page
    When user input username textbox with "standard_user"
    And user input password textbox with ""
    And user click login button
    Then user will see error message "is required"

  @WEB
  Scenario: add item to cart (positive)
    Given user is on login page
    When user input username textbox with "standard_user"
    And user input password textbox with "secret_sauce"
    And user click login button
    And user click add to cart
    And user click add to cart
    Then number of items appear on cart icon "2"

  @WEB
  Scenario: remove item from cart (positive)
    Given user is on login page
    When user input username textbox with "standard_user"
    And user input password textbox with "secret_sauce"
    And user click login button
    And user click add to cart
    And user click add to cart
    And user click add to cart
    And user click add to cart
    And user remove item
    Then number of items appear on cart icon "3"

  @WEB
  Scenario: checkout item (positive)
    Given user is on login page
    When user input username textbox with "standard_user"
    And user input password textbox with "secret_sauce"
    And user click login button
    And user click add to cart
    And user click cart icon
    Then user will direct to cart page

  @WEB
  Scenario: Checkout item without filling name and/or zip code data (negative)
    Given user is on login page
    When user input username textbox with "standard_user"
    And user input password textbox with "secret_sauce"
    And user click login button
    And user click add to cart
    And user click add to cart
    And user click add to cart
    And user click cart icon
    And user remove item from cart
    And user remove item from cart
    And user click checkout button
    Then user direct to data entry page
    And user click continue button
    And user input first name textbox with "supriyanto"
    And user input zip code textbox with "10110"
    Then user will see error warning "is required"

  @WEB
  Scenario: Checkout item by filling name and zip code data (positive)
    Given user is on login page
    When user input username textbox with "standard_user"
    And user input password textbox with "secret_sauce"
    And user click login button
    And user click add to cart
    And user click cart icon
    And user click checkout button
    And user input first name textbox with "raffi"
    And user input last name textbox with "ahmad"
    And user input zip code textbox with "10110"
    And user click continue button
    Then user will direct to overview page
    And user click finish button
    Then user will receive thank you message "Thank you"

