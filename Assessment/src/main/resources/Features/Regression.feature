@Regression

Feature: fedex assessment regression feature
#  Test case regression feature
  Scenario Outline: Fedex home page title verification
    Given user launch the fedex url
    Then user will get location modal
    When user clicks on english option from the location modal
    Then user will navigate to the fedex "<title>" home page
    Then verify the all services available on home page
    And clicks on the Tracking service and enters the "<trackID>"
    And clicks on the signIn CTA and verify the user navigate to the login page
    When user clicks on create a user id for an existing account
    Then user will navigate to the login registration page
    And fills the required details
    And Enter the "<userID>" and "<password>" and clicks on login button
    And clicks on the Forgot your user name or password link
    Then user clicks on the reset password CTA and navigate to other page
    And clicks on the Retrive user ID CTA
    Then click on the Shipping option from the login page
    Then verify the "<url>" of ship without account
    Then verify "<yourName>" and "<postalCode>" fields from the ShipManager lite page
    Then verify the "<country>"  field from the ShipManager lite page

    Examples:
      |userID    |  password |   title     |         url         |yourName|postalCode|trackID|
      |userName|password|HomePageTitle|ShipWithoutaccountURL|Shalini |1188lk    |trackID     |

