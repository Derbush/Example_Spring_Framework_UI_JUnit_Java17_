Feature: Files upload example

Scenario: Setting Procurement Prices. Successful Upload of Primary: Verification of Data Display on the <My Files> Page.
  Given User logs into the RAP using the role of "role"
  When User clicks on "module"
  And User selects the Advertising Campaign "Campaign Name"
  And User clicks "Action" button
  And User clicks the "Upload" button
  And User selects the file "TestFileForUpload.xlsx"
  And User clicks the Submit button
  Then Validation notification appears: "File uploaded successfully."

