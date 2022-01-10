PROJECT NAME: TIMESHEET


DESCRIPTION: 

	Login to Be.Cognizant.com, verify the user and search for "Timesheet" and switch to timesheet window by handling the windows and verifying the first three rows in the timesheet summary.


DELIVERABLES : 

	* Verify the User logged in.

	* Verify the dates of the first three rows in the timesheet summary dynamically.


TEAM MEMBERS :

	* DHANUSH S (2072792)

	* DIVYADHARSHINI (EMP ID)

	* GAYATHRI (EMP ID)

	* ARTHY S (EMP ID)

	* SARANYA (EMP ID)


TECHNOLOGIES USED : 

	* The automation script is written using SELENIUM(4.1.1) with JAVA.

	* TestNG has been used to make tests more readable and maintainable.

	* DATA DRIVEN FRAMEWORK has been used to drive test cases from an external data feed.

	* PAGE OBJECT MODEL (POM) has been used to create an object repository to store all the web elements.

	* EXTENT-REPORTS has been used to generate HTML documents with pie charts, screenshots, custom logs etc...


OTHER COMPONENTS :
	
	* Created UTILITY FUNCTIONS for often re-used functions to reduce code duplication.

	* Implemented Error/Exception Handling using try/catch methods.

	* Implemented Web page Synchronization and Wait interface usage.

	* Fulfilled naming conventions, code comments and folder structure.

	* MAVEN is implemented to create and manage the project.


PROCEDURE :

	* Open the link be.cognizant.com

	* Login with your Cognizant email and password.

	* Verify user logged in is the same as the user displayed on the homepage.

	* Search for "Timesheet" in the search bar.

	* Select "ESA Timesheet" from the displayed list.

	* In the new window, verify the dates displayed for the first three rows in the timesheet summary.

	* Quit the browser.