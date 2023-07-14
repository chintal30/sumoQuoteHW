# SumoQuote
*  How to run the application using Terminal / cmd:

1. Please change config.properties > sumoQuote.data.loginId = UNUSED DUMMY EMAIL ID
   1. Open terminal in the file directory and use command: 
      1. mvn clean test -Dfilename=CreateUser : For testing 'New user creation' test scenario
      2. Please manually verify email address
      3. mvn clean test -Dfilename=Login : For testing 'Login and Setup Dashboard' test scenario
  2. We can also run the test cases using
     1. Path: testng_CreateUser_runner.xml > Right click > Run > manually verifying email id,
      and then Path: xmlRunners/testng_Login_runner.xml > Right Click >Run
     2. Path : src/test/java/com/sumoQuote/testRunners/SampleTest.java > 
        1. accountCreationTest > Right click > Run > manually verifying email id
        2. loginAndSetupTest > Right click > Run

Important Notes:
1. Sample reports are stored at Path : reports/
2. 










