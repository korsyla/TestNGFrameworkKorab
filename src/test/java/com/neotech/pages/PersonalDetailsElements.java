package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utilities.CommonMethods;

public class PersonalDetailsElements extends CommonMethods {
	
	@FindBy(id = "employeeId")
	public WebElement employeeID;
	
	@FindBy(id = "pimPersonalDetailsForm")
	public WebElement personalDetailsForm;
	
	
	public PersonalDetailsElements() 
	{
		PageFactory.initElements(driver, this);
	}

}
