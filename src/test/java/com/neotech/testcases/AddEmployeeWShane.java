package com.neotech.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.neotech.pages.AddEmployeeElements;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.pages.PersonalDetailsElements;
import com.neotech.utilities.CommonMethods;
import com.neotech.utilities.ExcelUtility;

public class AddEmployeeWShane extends CommonMethods {
	
	
	@Test(dataProvider = "excelData", groups = {"addEmployeeRe", "regression"})
	public void addEmployeeRe(String firstName, String lastName, String username, String password) 
	{
		LoginPageElements loginPage = new LoginPageElements();
		DashboardPageElements dashboardPage = new DashboardPageElements();
		AddEmployeeElements addEmployeePage = new AddEmployeeElements();
		PersonalDetailsElements personalDetailsPage = new PersonalDetailsElements();
		 
		//log information in test report
		test.info("Test Data : " + firstName + " " + lastName);
		
		// Logging in
		test.info("Logging IN...!");
		loginPage.userLogin();
		wait(1);
		
		click(dashboardPage.pimButton); 
		click(dashboardPage.addEmployeeButton); 
		wait(1);
		
		//New employee info
		sendText(addEmployeePage.firstName, firstName);
		sendText(addEmployeePage.lastName, lastName);
		
		//Get Employee ID for Verification
 		String expectedID = addEmployeePage.employeeID.getAttribute("value");
		selectDropdown(addEmployeePage.location, "Texas R&D"); 
		wait(1);
		
		jsClick(addEmployeePage.loginDetailsButton);
		
		//Provide Credentials
		sendText(addEmployeePage.username, username);
		sendText(addEmployeePage.password, password);
		sendText(addEmployeePage.confirmPassword, password);
		
		wait(1);
		click(addEmployeePage.saveButton);
		
		
		waitForVisability(personalDetailsPage.personalDetailsForm); 
		
		//Validation
		test.info("Validation for the new employee");
		String actualID =  personalDetailsPage.employeeID.getAttribute("value");
		
		Assert.assertEquals(actualID, expectedID, "Employee ID's do NOT match");
//		System.out.println("Actual id is -> " + actualID);
//		System.out.println("Actual id is -> " + expectedID);
		System.out.println("Test Passed!!");
	}
	
	@DataProvider(name = "excelData")
	public Object[][] getExcelData() 
	{
		String excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testdata/Excel.xlsx";
//		String excelSheetName = "Employee";
		return ExcelUtility.excelIntoArray(excelFilePath, "Employee");
	}
	
	
	

}
