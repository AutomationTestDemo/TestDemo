Feature: Assignment

  @login @reg
  Scenario Outline: Login

    Given I am on page "<url>"
    And user enter "<username>" and "<pass>"
    And user click on login button
#    Then  I verify the blank image in slide bar

    Examples:
      | url        | username         | pass      |
      | blankImage | test22@gmail.com | 123456789 |



  @addCart  @reg
  Scenario Outline: Add product to cart

    Given I am on page "<url>"
    And user enter "<username>" and "<pass>"
    And user click on login button
    And user click on add product
    And user click on "<auction>" type
    And user click on next step button "1"
    And user enters the required fields
    And user enters the auction "<details>"
    And user enters the policy "<policyDetails>"
    And user upload main image
    And user click on next step button "2"
    And user enter buy now value
    And user enter start bid value
    And user enter increase bid
    And user enter date
    And user enter time
    And user enter the auction show type


    Examples:
      | url        | username         | pass      | auction            | details                | policyDetails         |
      | blankImage | test22@gmail.com | 123456789 | opt-single_product | This is Auction Detail | This is policy Detail |


