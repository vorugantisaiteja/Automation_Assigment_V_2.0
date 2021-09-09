# Framework Info
 Page Object Model framework is designed in such a way that page class files and testcases are maintained in separate folders and page wise objects to be created in the test cases in order to access page wise elements and perform some actions related to the page.
   1. Page classes are present in src/main/java/com.swaglabs.page folder
   2. Common utilities are present in src/main/java/com.swaglabs.utility folder
   3. Test Cases are present in src/test/java/com.swaglabs.testcases folder
 

# Folder Structure
1. src/main/java -> com.swaglabs.page      -> Add_Remove_Cart.java, Login.java, Product_Page.java 
2. src/main/java -> com.swaglabs.utility   -> BaseClass.java, ScreenshotUtility.java, Scroll.java, WaitUtility.java
3. src/test/java -> com.swaglabs.testcases -> Verify_Gridview_Checkout.java, Verify_Listview_Multiple_Products_Checkout.java, Verify_Listview_Add_Remove_Checkout.java,                                                        Verify_Product_Checkoutpage.java
4. src/test/resources -> log4j.properties
5. src/main/utility   -> logs ->  Appiumlogs.log
6. src/main/utility   -> Screenshots
7. configs            -> Configuration.properties

# Getting Started
.jar files to be installed with choice of version

#jar file#             #Version#
1. java-client    -     7.5.1
2. selenium-java  -     3.141.59
3. testng         -     7.3.0
4. log4j          -     1.2.17
5. commons-io     -     2.6

# Important Files
1. Log4j.properties file is stored in src/test/resources folder
2. Captured logs will be stored in src/main/utility/logs folder
3. Screenshots get saved and stored in src/main/utility/screenshots folder in case of bugs
4. Configuration.properties file is stored in configs folder
5. A detailed html report named as SwagLabsApp_Automation_Report.html is generated after test execution and will be stored in TestReport folder 
6. Screenshots of bugs are attached to the SwagLabsApp_Automation_Report.html report
