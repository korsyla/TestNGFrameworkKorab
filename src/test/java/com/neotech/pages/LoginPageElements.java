package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utilities.CommonMethods;
import com.neotech.utilities.ConfigsReader;

public class LoginPageElements extends CommonMethods {
	
	@FindBy(id = "txtUsername")
	public WebElement username;
	
	@FindBy(id = "txtPassword")
	public WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;
	
	@FindBy(id = "txtPassword-error")
	public WebElement emptyPasswordMssge;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement invalidPasswordMssge;
	
	
	public LoginPageElements() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Here, we are logging in, when we call this method in a test it will log us in
	public void userLogin() 
	{
		sendText(username, ConfigsReader.getProperty("username"));
		sendText(password, ConfigsReader.getProperty("password"));
		click(loginButton);
	}

}
