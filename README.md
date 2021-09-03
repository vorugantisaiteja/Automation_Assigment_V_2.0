# Framework Info
 Page Object Model framework is designed in such a way that page class files and testcases are maintained in separate folders and page wise objects to be created in the test cases in order to access page wise elements and perform some actions related to the page.
 Page classes are present in src/main/java/com.swaglabs.page folder
 Common utilities are present in src/main/java/com.swaglabs.utility folder
 Test Cases are present in src/test/java/com.swaglabs.testcases folder
 

# Folder Structure
1. src/main/java -> com.swaglabs.page      -> Add_Remove_Cart.java, Login.java, Product_Page.java 
2. src/main/java -> com.swaglabs.utility   -> BaseClass.java, ScreenshotUtility.java, Scroll.java, WaitUtility.java
3. src/test/java -> com.swaglabs.testcases -> Verify_Gridview_Checkout.java, Verify_Listview_Multiple_Products_Checkout.java, Verify_Listview_Add_Remove_Checkout.java,                                                        Verify_Product_Checkoutpage.java
4. src/test/resources -> log4j.properties
5. src/main/utility   -> logs ->  Appiumlogs.log
6. src/main/utility   -> Screenshots
7. configs            -> Configuration.properties

# Getting Started
.jar files to be installed

#jar file#        #Version#
java-client    -     7.5.1
selenium-java  -     3.141.59
testng         -     7.3.0
log4j          -     1.2.17
commons-io     -     2.6

