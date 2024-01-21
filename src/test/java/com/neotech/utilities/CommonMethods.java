package com.neotech.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.testbase.BaseClass;

public class CommonMethods extends BaseClass {

//---------------------------------------- COMMON METHOD #1 ---------------------------------------------

	/**
	 * This method will clear the textBox WebElement first, then I send the text that I want
	 * @param textBox
	 * @param text
	 */
	public static void sendText(WebElement textBox, String text ) 
	{
		textBox.clear(); //Clear the textBox element and clear it
		textBox.sendKeys(text); //In the textBox send the text value we want
	}
	
//---------------------------------------- COMMON METHOD #2 --------------------------------------------------------------	
	
	/**
	 * This method checks if a radio/check box is enabled, then clicks on the element matching input that we give value that we are trying to selectValue
	 * @param elementList
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement> elementList, String selectValue) 
	{
		for(WebElement el : elementList) //This means for every single WebElelemnt in elementList(List of WebElements)
		{
			//Here we are getting the value of a particular el of a single button of checkbox/radiobutton / .trim means there is no space before or after the value
			//"value" -> is an Attribute name it doesn't change it comes from HTML document
			String elementValue = el.getAttribute("value").trim(); 
			
			//This means if the VALUE of the el that we're on as we looping is equals 
			//to my input String selectValue that im looking for that i need to click/tick on && and the el is enabled
			//than el.click select on that element / once we find it break out of it
			if(elementValue.equals(selectValue) && el.isEnabled()) 
			{
				el.click();
				break;
			}
		}
	}
	
//---------------------------------------- COMMON METHOD #3 -------------------------------------------------------------
	
	/**
	 * This method allows us to call Thread.sleep() for a certain amount of seconds that we give(which is our input), 
	 * @param seconds
	 */
	public static void wait(int seconds) 
	{
		try 
		{
			Thread.sleep(seconds * 1000); //if we give 5, it will multiply 5 * 1000 and give us 5 seconds wait
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		} 
	}

//---------------------------------------- COMMON METHOD #4 -------------------------------------------------------------
	
	/**
	 * This method checks whether a visible text is found in a drop-down and selects it. 
	 * if visible text doesn't exist, it will print in console the details of the element that is not in the SelectDD
	 * @param element
	 * @param visibileText
	 */
	public static void selectDropdown(WebElement element, String visibileText) //This method asks the user(me), to give/find the particular dropwdown WebElement element that we want, and give the visibleText value of that element to select
	{
		try 
		{
			Select sel = new Select(element);
			sel.selectByVisibleText(visibileText);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}
	
	
//---------------------------------------- COMMON METHOD #5 -------------------------------------------------------------

	/**
	 * This method checks if a given index is valid, and selects it if so
	 * @param element
	 * @param index
	 */
	public static void selectDropdown(WebElement element, int index) //This method asks the user(me), to give/find the particular dropwdown WebElement element that we want, and give the index number of that element to select
	{
		try 
		{
			Select sel = new Select(element);
			sel.selectByIndex(index);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
//---------------------------------------- COMMON METHOD #6 -------------------------------------------------------------

	/**
	 * This method switches to alert and accepts the alert. If no alert is found NoAlertPresentException details will be printed
	 */
	public static void acceptAlert() 
	{
		try 
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} 
		catch (NoAlertPresentException e) //We have this catch Exception just in case is not present anymore 
		{
			e.printStackTrace();
		}
	}
	
//---------------------------------------- COMMON METHOD #7 -------------------------------------------------------------

	/**
	 * This method will dismiss an alert if it is present
	 */
	public static void dissmisAlert() 
	{
		try 
		{
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} 
		catch (NoAlertPresentException e) //We have this catch Exception just in case is not present anymore
		{
			e.printStackTrace();
		}
	}
	
//---------------------------------------- COMMON METHOD #8 -------------------------------------------------------------

	/**
	 * This method will return the alert text, if text is present. If not it will return null/empty/nothing
	 * 
	 * @return
	 */
	public static String getAlertText() //Here if we get the alert, we RETURN or alert can be empty if no text is in there
	{
		String alertText = null; //At frist alerText is null/empty/nothing
		try 
		{
			Alert alert = driver.switchTo().alert();
			alertText =alert.getText(); 
		} 
		catch (NoAlertPresentException e) 
		{
			e.printStackTrace();
		}
		return alertText;
	}
	
//---------------------------------------- COMMON METHOD #9 -------------------------------------------------------------

	/**
	 * This method sends text to the alert if the alert is present
	 * @param text
	 */
	public static void sendAlertText(String text) //Here the user(me), is sending the text that I want 
	{
		try 
		{
			Alert alert = driver.switchTo().alert(); //I located the alert
			alert.sendKeys(text);  //Send the text/message that we want in that alert
		} 
		catch (NoAlertPresentException e) 
		{
			e.printStackTrace();
		}
	}
	
//---------------------------------------- COMMON METHOD #10 -------------------------------------------------------------

	/**
	 * This method switches to a frame using name or id, if they are available
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) //Here, we are expecting user(me) to give/input name or id of the frame and switch to it
	{
		try 
		{
			driver.switchTo().frame(nameOrId);
		} 
		catch (NoSuchFrameException e) 
		{
			e.printStackTrace();
		}
	}
	
//---------------------------------------- COMMON METHOD #11 -------------------------------------------------------------

	/**
	 * This method switches to a frame using index value of Iframe
	 * @param index
	 */
	public static void switchToFrame(int index) //Here, we are expecting user(me) to give/input index of the frame and switch to it
	{
		try 
		{
			driver.switchTo().frame(index);
		} 
		catch (NoSuchFrameException e) 
		{
			e.printStackTrace();
		}
	}
	
//---------------------------------------- COMMON METHOD #12 -------------------------------------------------------------

	/**
	 * This method switches to a frame using WebElement
	 * @param element
	 */
	public static void switchToFrame(WebElement element) //Here, we are expecting user(me) to give/input WebElement element of the frame and switch to it
	{
		try 
		{
			driver.switchTo().frame(element);
		} 
		catch (NoSuchFrameException e) 
		{
			e.printStackTrace();
		}
	}
	
	
//---------------------------------------- COMMON METHOD #13 -------------------------------------------------------------

	/**
	 * This method switches into the child window
	 */
	public static void switchToChildWindow() 
	{
		String mainWindow= driver.getWindowHandle();
		Set<String> allHandles  = driver.getWindowHandles();
		
		for(String handle : allHandles) 
		{
			if(!mainWindow.equals(handle)) //This means, if our main window is not equal to the child window, go inside the loop and switch to child window
			{
				driver.switchTo().window(handle); //go inside the loop and switch to child window
				break;
			}
		}
	}
	
	
//---------------------------------------- COMMON METHOD #14 -------------------------------------------------------------

	/**
	 * Creates a wait object
	 * @return
	 */
	public static WebDriverWait getWaitObject() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXCPLICIT_WAIT_TIME));
		return wait;
	}
	
//---------------------------------------- COMMON METHOD #14.5 -------------------------------------------------------------

	/**
	 * Creates a wait object
	 * @param secondsToWait
	 * @return
	 */
	public static WebDriverWait getWaitObject(int secondsToWait) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
		return wait;
	}
	
	
//---------------------------------------- COMMON METHOD #15 -------------------------------------------------------------

	/**
	 * Wait for the element to be clickable
	 * @param element
	 * @return
	 */
	public static WebElement waitForClickability(WebElement element) //Here we want to wait for Clickability of the Element I give in the parameters (WebElement element)
	{
		
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
//---------------------------------------- COMMON METHOD #16 -------------------------------------------------------------

	/**
	 * Wait for the element to be visible
	 * @param element
	 * @return
	 */
	public static WebElement waitForVisability(WebElement element) //Here we want to wait for Visability of the Element I give in the parameters (WebElement element)
	{
		
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
		
	}
	
//---------------------------------------- COMMON METHOD #17 -------------------------------------------------------------

	/**
	 * This method waits for an element to be clickable and then clicks it.
	 * @param element
	 */
	public static void click(WebElement element) //Wait for Element that we give to be CLICKABLE
	{
		waitForClickability(element);
		element.click();
	}
	
//---------------------------------------- COMMON METHOD #18 -------------------------------------------------------------
	
	/**
	 * This method will downcast the driver to a JavascriptExecutor object (js) and return it.
	 * @return
	 */
	public static JavascriptExecutor getJSObject() 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}
	
//---------------------------------------- COMMON METHOD #19 -------------------------------------------------------------
	
	/**
	 * This method will click on an element using JavascriptExecutor
	 */
	public static void jsClick(WebElement element) 
	{
		getJSObject().executeScript("arguments[0].click()", element);
	}
	
//---------------------------------------- COMMON METHOD #20 -------------------------------------------------------------

	/**
	 * This method will scroll the page until a specific element that we want is in view
	 * This is scroll into VIEW of an, element
	 */
	public static void scrollToElement(WebElement element) 
	{
		getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
//---------------------------------------- COMMON METHOD #21 -------------------------------------------------------------

	/**
	 * This method scrolls the page up based on the pixel parameters we give.
	 * @param pixel
	 */
	public static void scrollUp(int pixel) 
	{
		getJSObject().executeScript("window.scrollBy(0, -"+pixel+")");
	}
	
//---------------------------------------- COMMON METHOD #22 -------------------------------------------------------------

	/**
	 * This method scrolls the page down based on the pixel parameters we give.
	 * @param pixel
	 */
	public static void scrollDown(int pixel) 
	{
		getJSObject().executeScript("window.scrollBy(0, "+pixel+")");
	}
	
//---------------------------------------- COMMON METHOD #23 -------------------------------------------------------------

	/**
	 * This method selects a date from the calendar given the List<WebElement> and the date to select
	 * Also, This method is for selecting the days in a Calendar
	 */
	public static void selectCalendarDate(List<WebElement> elements, String date) 
	{
		for(WebElement day : elements) 
		{
			if(day.getText().equals(date)) 
			{
				if(day.isEnabled()) 
				{
					day.click();
					break;
				}
				else 
				{
					System.out.println("This day is not enabled!!");
					break;
				}
						
			}
		}
	}
	
	
//---------------------------------------- COMMON METHOD #23 -------------------------------------------------------------
	/**
	 * This method takes a screenshot using the provided screenshotName that we give
	 * @param screenshotName
	 */
	public static String takeScreenshot(String screenshotName) 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File pictureFile = ts.getScreenshotAs(OutputType.FILE);
		
		String fileDestination = Constants.SCREENSHOT_FILEPATH + screenshotName + getTimeStamp() + ".png";
		
		try 
		{
			FileUtils.copyFile(pictureFile, new File(fileDestination));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return fileDestination;
		
	}
	
	/**
	 * This method returns the time stamp in a String format
	 * @return
	 */
	public static String getTimeStamp() 
	{
		Date date = new Date();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return simpleDateFormat.format(date);
	}
	
	
	
}
