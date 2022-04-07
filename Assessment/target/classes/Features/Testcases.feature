
Feature: fedex assessment home page

#  Test case 1 user see the all available services
  @test1
  Scenario Outline: Fedex home page title verification
    Given user launch the fedex url
    Then user will get location modal
    When user clicks on english option from the location modal
    Then user will navigate to the fedex "<title>" home page

    Examples:
      |title|
      |HomePageTitle|
# Test case 2 user clicks on the shipping services
  @test2
  Scenario: User checks all available services on the home page
    Given user launch the fedex url
    Then user will get location modal
    When user clicks on english option from the location modal
    Then verify the all services available on home page

 #Test case 3 new user navigate to the login page
  @test3
  Scenario: New user navigate to login from the home page
    Given user launch the fedex url
    Then user will get location modal
    When user clicks on english option from the location modal
    Then verify the user navigate to the login page
    And verify the login page details

   #Test case 4 new user navigate to the login from the page and enters the login details
  @test4
  Scenario Outline: New user try to login using the user name and password
    Given user launch the fedex url
    Then user will get location modal
    When user clicks on english option from the location modal
    Then verify the user navigate to the login page
    And Enter the "<userID>" and "<password>" and clicks on login button
    Examples:
      |userID  |password|
      |userName|password|

  #Test case 5 new user navigate to the login from the page and clicks on the forgot userid link
  @test5
  Scenario: New user try to reset his/her password
    Given user launch the fedex url
    Then user will get location modal
    When user clicks on english option from the location modal
    Then verify the user navigate to the login page
    And clicks on the Forgot your user name or password link

   #Test case 6 new user navigate to the login from the page and try to reset password
  @test6
  Scenario: New user try to reset his/her user id
    Given user launch the fedex url
    Then user will get location modal
    When user clicks on english option from the location modal
    Then verify the user navigate to the login page
    And clicks on the Forgot your user name or password link
    Then user clicks on the reset password CTA and navigate to other page

   #Test case 7 new user navigate to the login from the page and try to retrive user id
  @test7
  Scenario: New user New user try to reset his/her userID
    Given user launch the fedex url
    Then user will get location modal
    When user clicks on english option from the location modal
    Then verify the user navigate to the login page
    And clicks on the Forgot your user name or password link
    Then user clicks on the reset password CTA and navigate to other page
    And clicks on the Retrive user ID CTA

  # Test case 8 user navigate to the ShipManager lite page validate the url
  @test8
  Scenario Outline: New user ship without account page
    Given user launch the fedex url
    Then user will get location modal
    When user clicks on english option from the location modal
#    Then verify the all services available on home page
    When user clicks on the Ship without account option from shipping services
    Then verify the "<url>" of ship without account

    Examples:
      |url|
      |ShipWithoutaccountURL|


# Test case 9 user navigate to the ShipManager lite page and enters the details
  @test9
  Scenario Outline: New user is in ship without account page and enter some details
    Given user launch the fedex url
    Then user will get location modal
    When user clicks on english option from the location modal
    When user clicks on the Ship without account option from shipping services
    Then verify "<yourName>" and "<postalCode>" fields from the ShipManager lite page

    Examples:
      |yourName|postalCode|
      |Shalini|1188lk |

  #Test case 10 user navigate to the ShipManager lite page verification of country from the page
  @test10
  Scenario Outline: New user ship in without account page and enters the country detail
    Given user launch the fedex url
    Then user will get location modal
    When user clicks on english option from the location modal
    When user clicks on the Ship without account option from shipping services
    Then verify the "<country>"  field from the ShipManager lite page
    Examples:
      |country|
      |ShipWithoutaccountURL|