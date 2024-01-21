package com.neotech.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.AddEmployeeElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.pages.PersonalDetailsElements;
import com.neotech.utilities.CommonMethods;
import com.neotech.utilities.ConfigsReader;
import com.neotech.utilities.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {
	
	@Test(dataProvider = "excelData", groups = "addEmp")
	public void addEmployee(String firstName, String lastName, String username, String password) 
	{
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		AddEmployeeElements addEmployee = new AddEmployeeElements();
		PersonalDetailsElements personalDetails = new PersonalDetailsElements();
		
		//Login
//		test.info("Logging in");
		sendText(login.username, ConfigsReader.getProperty("username")); 
		sendText(login.password, ConfigsReader.getProperty("password")); 
		click(login.loginButton); 
		
		//navigate to PIM and click Add Employee
//		test.info("Clicking on PIM and Add Employee Buttons");
		click(dashboard.pimButton); 
		click(dashboard.addEmployeeButton); 
		
		//Send Info of New Employee
//		test.info("Sending info of New Employee");
 		sendText(addEmployee.firstName, firstName); 
 		sendText(addEmployee.lastName, lastName); 
 		selectDropdown(addEmployee.location, "Texas R&D"); 
 		//Get the Empooyee ID for verification
 		String expectedID = addEmployee.employeeID.getAttribute("value");
 		//Click on Creat Login Details Button and send more info
// 		test.info("Clicking on Login Details Button and sending more new Employee info");
 		jsClick(addEmployee.loginDetailsButton); 
 		sendText(addEmployee.username, username); 
 		sendText(addEmployee.password, password); 
 		sendText(addEmployee.confirmPassword, password); 
 		//Click on SAVE button
 		wait(1);
// 		test.info("clicked on SAVE button");
 		click(addEmployee.saveButton); 
 		waitForVisability(personalDetails.personalDetailsForm); 
 		
 		String actualID = personalDetails.employeeID.getAttribute("value");
 		Assert.assertEquals(expectedID, actualID, "ID's do NOT match");
 		
	}
	
	@DataProvider(name = "excelData")
	public Object[][] getExcelData() 
	{
		String excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testdata/Excel.xlsx";
		String excelSheetName = "Employee";
		return ExcelUtility.excelIntoArray(excelFilePath, excelSheetName);
	}
	

}
