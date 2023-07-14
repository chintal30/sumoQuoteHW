# SumoQuote
Platform Used: Windows OS, Chrome Browser (Prerequisites)
<h4>Ways to execute test cases:</h4>
<h5>Please change "root/config.properties" file's email parameter > sumoQuote.data.loginId = UNUSED DUMMY EMAIL ID for testing</h5>

1. Open cmd in the file directory and use command: 
   1. "mvn clean test -Dfilename=CreateUser" : For testing 'New user creation' test scenario
   2. Please manually verify email address
   3. "mvn clean test -Dfilename=Login" : For testing 'Login and Setup Dashboard' test scenario
2. We can also run the test cases using
   1. Path: "xmlRunners/testng_CreateUser_runner.xml" > Right click > Run > manually verifying email id,
    and then Path: "xmlRunners/testng_Login_runner.xml" > Right Click > Run
   2. Path : "src/test/java/com/sumoQuote/testRunners/SampleTest.java" > 
      1. "accountCreationTest" > Right click > Run > manually verifying email id
      2. "loginAndSetupTest" > Right click > Run

Important Notes:
1. Sample reports are stored at Path : "reports/"
2. 










