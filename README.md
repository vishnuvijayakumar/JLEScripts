# JLEScripts
BDD cucumber scripts

# Prerequisites
1. Java JDK to be installed (Tested with Open JDK 19.0.1) and ensure that environment variable is set
2. Latest chrome browser
3. Clone the project and open in the desired IDE, ensure that the project is marked as Maven
    To do the same in Intellij:
     a. Open project in Intellij, right click project and go to module settings
     b. Select module sdk under dependencies
     c. Rebuild the project
     d. Right click pom.xml and mark as Maven project

# Features and Reports
1. Cucumber features can be found in src>test>resources>features
2. Reports will be generated under target>Reports>report.html (Open in any browser)
3. To refer sample report without running scripts: src>test>resources>SampleReport>report.html

# How to run scripts
1. Right click on testng.xml and click on run
2. Scritps can be also run from command line without installing any IDEs

# Scenarios covered
1. Remove default content, add new code and execute 
2. Change the font size and validate whether its getting reflected
3. Add external libarary
4. Save project with a name 
5. Delete project after seacrching it

# Note: For scenario 4, username and password to be filled in the feature file. Existing credentials wont work. For Scenario 5, valid project name to be given in the feature file. It will work if Scenario 4 is successful, since same project name is given in both cases

