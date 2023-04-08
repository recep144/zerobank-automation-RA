Feature: Log in as user

  Background:
    Given The user is on the login page
    When The user should be click Signin button

  @WrongInfo
  Scenario Outline: Negative Login with Different Info
    When The user logs in using "<userEmail>" and "<password>"
    Then Verify that "<text>" is visible on the login page

    Examples:
      | userEmail     | password      | text                             |
      |               |               | Login and/or password are wrong. |
      | wrongUserName | password      | Login and/or password are wrong. |
      | username      | WrongPassword | Login and/or password are wrong. |

  @wip
  Scenario: Login as Zero Bank
    Then The user logs in using "username" and "password"
    Then The user logs the main page with the other url
    Then The user should be able to login
    And Verify that "Account Summary" is visible on the Main Page
    Then Validate all tabs are on the Account Summary Page
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then Validate all tabs are on the Credit Accounts Table
      | Account     |
      | Credit Card |
      | Balance     |

    Then The user should be able to enter the "Account Activity" page
    Then Verify that "Savings" is visible on the Account Activity page
    Then Verify that account menu should be include the following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

    Then Verify that Transactions table should be include the following options
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |

    Then The user should be able to enter the "Pay Bills" page
    Then The user enter valid credentials with:
      | Payee       | Bank of America |
      | Account     | Checking        |
      | Amount      | 1000000         |
      | Date        | 01042023        |
      | Description | trade           |
     And Verify that "The payment was successfully submitted." message is visible on the Pay Bills page


  Scenario Outline: Negative Pay with Different Info
    Then The user logs in using "username" and "password"
    Then The user logs the main page with the other url
    Then The user should be able to enter the "Pay Bills" page
    When The user should be able to pay using "<Amount>" and "<Date>"
    And Verify that "<text>" is visible on the Pay Bills page
    Examples:
      | Amount     | Date       | text                       |
      |            |            | Please fill in this field. |
     # | alphabetic | alphabetic | Please fill in this field. |
     # | */-+*/*    | 9999.99.99 | Please fill in this field. |




