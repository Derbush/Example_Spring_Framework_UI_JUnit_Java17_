Feature: File Downloads Examples

Scenario: Downloading the Primary template
  Given User logs into the RAP using the role of "Buying Manager"
  When User clicks on "module"
  And User clicks the "action" button
  And User clicks the "Download Primary" button
  Then Modal window appears on the "Page" with the message "Downloading file" and "Please wait. The file is downloading."
  And Progress bar is displayed
  And Validation notification appears: "File downloaded successfully"
  And File with the name "TestName" is downloaded to the designated space on the local computer.