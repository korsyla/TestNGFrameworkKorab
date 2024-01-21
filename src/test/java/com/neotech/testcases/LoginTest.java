package com.neotech.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utilities.CommonMethods;
import com.neotech.utilities.ConfigsReader;

public class LoginTest extends CommonMethods {
	
	@Test //(groups = {"smoke", "regression"}, priority = 0)
	public void validLogin() 
	{
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		
		//Entering
//		test.info("Entering valid login credentials.");
		sendText(login.username, ConfigsReader.getProperty("username")); wait(1);
		
		sendText(login.password, ConfigsReader.getProperty("password")); wait(1);
		
//		test.info("Clicking on the loggin button.");
		click(login.loginButton); wait(1);
		
		//Verify User account manager name 
//		test.info("Verifying that user is logged in.");
		String expected = "Jacqueline White";
		String actual = dashboard.accountName.getText();
		//Assertion -> Here we are Validation if names match
		Assert.assertEquals(expected, actual, "Account Names do NOT match!");	
	}
	
	
	
	@Test(groups = "regression", priority = 1, enabled = false)
	public void emptyPasswordLogin() 
	{
		LoginPageElements login = new LoginPageElements();
		
		sendText(login.username, ConfigsReader.getProperty("username")); wait(1);
		jsClick(login.loginButton); wait(1);
		
		//Verify error message with text "Password cannot be empty" is displayed.
		String excpectedMssge = "Password cannot be empty";
		String actualMssge = login.emptyPasswordMssge.getText();
		Assert.assertEquals(excpectedMssge, actualMssge, "Messages for Empty Passwords do NOT match");
//		takeScreenshot("emptyPassword");
	}

	
	
	@Test(groups = "regression", priority = 2, enabled = false)
	public void invalidPasswordLogin() 
	{
		LoginPageElements login = new LoginPageElements();
		
		//Send Login Data
		sendText(login.username, ConfigsReader.getProperty("username")); wait(1);
		sendText(login.password, "wrongPassword");  wait(1);
		click(login.loginButton);  wait(1);
		
		//Verify error message with text "Invalid Credentials" is displayed
//		WebElement invalidMssge = login.invalidPasswordMssge;
//		Assert.assertTrue(invalidMssge.isDisplayed(), "Invalid credentials message is NOT displayed!!!");
		String expectedMessage = "Invalid Credentials";
		String actualMessage = login.invalidPasswordMssge.getText();
		Assert.assertEquals(expectedMessage, actualMessage, "Invalid credentials Messages do NOT match!");
		
//		takeScreenshot("invalidPassword");
		
	}
	
	
	
	

}
