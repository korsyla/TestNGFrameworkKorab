package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utilities.CommonMethods;

public class DashboardPageElements extends CommonMethods {
	
	//ALL the DASHBOARD WebElements will be @FindBy in this DashboardPage
	
	@FindBy(id = "account-name")
	public WebElement accountName;
	
	@FindBy(xpath = "//span[text()='PIM']")
	public WebElement pimButton;
	
	@FindBy(xpath = "//span[text()='Add Employee']")
	public WebElement addEmployeeButton;
	
	
	//This -> means we are going to use the driver for everything in THIS class, all the WebElements etc
	public DashboardPageElements() 
	{
		PageFactory.initElements(driver, this);
	}
	

}
