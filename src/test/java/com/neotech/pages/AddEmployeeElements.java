package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utilities.CommonMethods;

public class AddEmployeeElements extends CommonMethods {
	
	@FindBy(id = "first-name-box")
	public WebElement firstName;
	
	@FindBy(id = "last-name-box")
	public WebElement lastName;
	
	@FindBy(id = "location")
	public WebElement location;
	
	@FindBy(id = "employeeId")
	public WebElement employeeID;
	
	@FindBy(id = "hasLoginDetails")
	public WebElement loginDetailsButton;
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "confirmPassword")
	public WebElement confirmPassword;
	
	@FindBy(id = "modal-save-button")
	public WebElement saveButton;
	
	
	
	public AddEmployeeElements() 
	{
		PageFactory.initElements(driver, this);
	}

}
