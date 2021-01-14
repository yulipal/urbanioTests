Feature: Login in Urbanio


  Scenario Outline: I login as a current user in Urbanio
    Given I open Urbanio webpage in a new webBrowser
    And I login with the credentials username <username> and password <password> in the login page
    Then I see the main dashboard as a current user

    Examples:
      | username       | password |
      | user@gmail.com | mypass   |

  Scenario Outline: I login as an admin user in Urbanio
    Given I open Urbanio webpage in a new webBrowser
    And I login with the credentials username <username> and password <password> in the login page
    Then I see the main dashboard as an admin

    Examples:
      | username        | password |
      | admin@gmail.com | mypass   |

  #Checked
  Scenario Outline: I insert invalid credentials to login in Urbanio
    Given I open Urbanio webpage in a new webBrowser
    And I login with the credentials username <username> and password <password> in the login page
    Then I see an error warning

    Examples:
      | username | password |
      | ergwerb  | wefwev   |
      | admin    | xxxx     |
      | user     | qevq!    |

