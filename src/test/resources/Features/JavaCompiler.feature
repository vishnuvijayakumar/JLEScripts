@test
Feature: Java Compiler should have features for maintaining java projects, add libraries and run java code

  Scenario Outline: User should be able to clear the default code, add new code and run
    Given the user launch the webpage and accept cookies
    When deleting the existing code
    And add the new java code
      | Code                                                                                                                                                                                              |
      | "\npublic class Multiplication {\n    public static void main(String args[]) {\n      int x=10;\n      int y=25;\n      int z=x*y;\n\n      System.out.println("Product of x*y = " + z);\n    \n" |
    And click on the execute button
    Then output should be shown with expected <Result>
    Examples:
      | Result               |
      | Product of x*y = 250 |


  Scenario Outline: User should be able to change the font of the editor
    Given the user launch the webpage and accept cookies
    When user change the font size to <Size>
    Then the editor should show the font size as <Size>
    Examples:
      | Size |
      | 17   |

  Scenario Outline: User should be able to add external libraries
    Given the user launch the webpage and accept cookies
    When the user clicks on External Libraries
    And add the jar <External Library>
    Then Library manager should have the <External Library>
    Examples:
      | External Library            |
      | org.testng:testng:jar:7.8.0 |


  Scenario Outline: User should be able to save the project
    Given the user launch the webpage and accept cookies
    When user clicks on login
    And enter the <Username> and <Password>
    And click on login button
    Then the user should get loggedIn
    When the user hovers over the side panel
    And click on the Save As
    And enters the project name as <ProjectName>
    And click on SaveAs button
    Then the project should get saved
    Examples:
      | Username            | Password    | ProjectName |
      | vishnuv92@gmail.com | T4Tesla@123 | DR123       |

  Scenario Outline:  User should be able to delete the project

    Given the user launch the webpage and accept cookies
    When user clicks on login
    And enter the <Username> and <Password>
    And click on login button
    Then the user should get loggedIn
    When the user hovers over the side panel
    And click on the My Projects
    And Enter the name in search field <ProjectName>
    And click on Show Results
    Then user should see the project listed <ProjectName>
    When clicking on delete button for the project <ProjectName>
    And user accepts delete confirmation
    Then success message should be shown for deletion
    Examples:
      | Username            | Password    | ProjectName |
      | vishnuv92@gmail.com | T4Tesla@123 | DR123       |