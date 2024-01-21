package com.neotech.utilities;

public class Constants {
	
	//****************   1st STEP  **********************
	
	//These are our CONSTANS PATHS to OUR CONFIGS and DRIVERS FILES in our PROJECT that will NOT Change
	//These are JUST ONLYYY location of our chromedriver.exe / geckodriver.exe / configuration.properties
	
	//With this, we locating the filepath/location of  configuration.properties that has key=value pairs
	public static final String CONFIGURATION_FILEPETH = System.getProperty("user.dir")
			+ "/src/test/resources/configs/configuration.properties";
	
	public static final String REPORT_FILEPATH = System.getProperty("user.dir") + "/target/html-report/HRMS.html";
	
	public static final String SCREENSHOT_FILEPATH = System.getProperty("user.dir") + "/screenshots/";
	
	public static final int EXCPLICIT_WAIT_TIME = 25;
	
	public static final int IMPLICIT_WAIT_TIME = 15;
	
	
	//user.dir -> gives us the location of our Project + configs + configuration.properties
	//String filePath = System.getProperty("user.dir") + "/configs/configuration.properties";
	//System.out.println(filePath);
	
}
