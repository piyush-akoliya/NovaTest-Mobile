Feature: Alert Dialogs testing using Appium

#  @tag1
#  Scenario: Testing the List Dialog option
#    Given I start the appium app
#    Then I select the App option
#    And I select the short dialog
#    Then I validate the message displayed "Lorem ipsum dolor sit aie consectetur adipiscing\nPlloaso mako nuto siwuf cakso dodtos anr koop."

  @tag2
  Scenario: Testing the Cross Platform functionality
    Given I load the CGI portal
    Then I login to the CGI TimeSheet
    And I select the new timesheet scenario
    Then I add the time and value