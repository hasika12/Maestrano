package frameworkLibrary;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class WebLibrary extends DriverClass
{
/**
 * To Enter text into text field
 * @param by		-- get element reference
 * @param strValue 	-- TestData
 * @param driver 	-- driver Reference
 * @return 			-- true/false
 * 
 */
	protected static boolean setText(By by,String strValue,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			if(highlightelement) highlight(by, driver);
			driver.findElement(by).click();
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(strValue);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	/**
	 * To Click on a Particular Field
	 * @param by		-- get element reference
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */
	protected static boolean clickElement(By by,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			if(highlightelement) highlight(by, driver);
			driver.findElement(by).click();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	/**
	 * To click on Array of Elements 
	 * @param by		-- get Element Referece
	 * @param driver	-- driver Reference
	 * @return			-- true/false
	 */
	protected static boolean clickElements(By by,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			List <WebElement>eleLists=driver.findElements(by);
			
			for(WebElement ele1:eleLists)
			{
				ele1.click();
			}
			
			stepstatus=true;
		}
		catch(Exception e)
		{
			stepstatus=false;
		}
		return stepstatus;
	}
	/**
	 * To Get Text From Element
	 * @param by		-- Get Element Reference
	 * @param driver	-- driver Reference
	 * @return			-- Element Text/Null
	 */
	
	protected static String getElementText(By by,String AttributeName,WebDriver driver)
	{
		try
		{
			String eleText;
			if(highlightelement) highlight(by, driver);
			eleText=driver.findElement(by).getAttribute(AttributeName);
			return eleText;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}
/**
 * 
 * @param by -- Select box reference
 * @param StrOptionvalue -- option value
 * @param driver -- driver reference
 * @return -- true/false
 */
	public static boolean selectOptionByText(By by,String StrOptionvalue,WebDriver driver)
	{
		boolean status;
		try
		{
			//Select s2 = new Select(driver.findElement(by));
			//s2.selectByValue(StrOptionvalue);
			Select s2 = new Select(driver.findElement(by));
			s2.selectByVisibleText(StrOptionvalue);
			
			Select s1 = new Select(driver.findElement(by));
			WebElement selectedOption = s1.getFirstSelectedOption();
			String SelectedValue = selectedOption.getAttribute("innerHTML");
			if(SelectedValue.equalsIgnoreCase(StrOptionvalue))
			{
				status = true;
			}
			else
			{
				status = false;
			}
		}
		catch(Exception e)
		{
			status = false;
		}		
		return status;
	}
	
	/**
	 * To Launch Browser Base on Name Given
	 * @param by		-- get element reference
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */
	protected static WebDriver launchBrowser(String BrowserName)
	{
		WebDriver Tempdriver = null;
		switch(BrowserName.toLowerCase())
		{
			case "firefox":
			{
				System.setProperty("webdriver.gecko.driver","BrowserServers\\geckodriver.exe");
				Tempdriver = new FirefoxDriver();
				break;
			}
			case "ie":
			case "internetexplorer":
			{
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				System.setProperty("webdriver.ie.driver", "BrowserServers\\IEDriverServer.exe");
				Tempdriver = new InternetExplorerDriver(capabilities);
				break;
			}
			case "chrome":
			{
				System.setProperty("webdriver.chrome.driver","BrowserServers\\chromedriver.exe");
				Tempdriver = new ChromeDriver();
				break;
			}
			default:
			{
				System.out.println("please Select the correct browser");
			}
		}
		return Tempdriver;
	}
	
	
	/**
	 * To Open URL in the Driver Reference
	 * @param URL  		--  	address of Web Application to Open
	 * @param driver 	-- 		driver Reference
	 * @return -- true/false
	 * 
	 */
	protected static Boolean OpenUrl(String URL,WebDriver driver)
    {
    	Boolean stepStatus = true;
    	try
    	{
    		driver.get(URL);
    		driver.manage().window().maximize();
    	}
    	catch(Exception e)
    	{
    		stepStatus = false;
    	}
    	String CurrentUrl = driver.getCurrentUrl();
    	if (!CurrentUrl.contains(URL))
    	{
    		stepStatus = false;
    	}
    	return stepStatus;
    }
	
	
	/**
	 * To Close all Window Instances.
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */
	protected static Boolean quitDriver(WebDriver driver)
    {
    	Boolean stepStatus;
    	try
    	{
    		driver.quit();
    		stepStatus = true;
    	}
    	catch(Exception e)
    	{
    		stepStatus = false;
    	}
    	return stepStatus;
    }

	/**
	 * To Verify Existence of WebElement
	 * @param by		-- get element reference
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */
	protected static boolean exists(By by,WebDriver driver)
	{
		List<WebElement> allitems = driver.findElements(by);
		boolean found = false;
		if (allitems.size()>0)
		{
			found = true;
		}
		else
		{
			found = false;
		}
		return found;
	}
	
	/**
	 * To Verify Existence of WebElement
	 * @param by		-- get element reference
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */
	protected static boolean notexists(By by,WebDriver driver)
	{
		List<WebElement> allitems = driver.findElements(by);
		boolean found = true;
		if (allitems.size()>0)
		{
			found = false;
		}
		else
		{
			found = true;
		}
		return found;
	}
	/**
	 * To Highlight Web Element
	 * @param by		-- get element reference
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */
	protected static void highlight(By by,WebDriver driver)
	{
        JavascriptExecutor js = (JavascriptExecutor)driver;
        try
        {
	        WebElement ele = driver.findElement(by);
	        for(int i = 1;i<=2;i++)
	        {
	        	Thread.sleep(400);
		        js.executeScript("arguments[0].style.border='solid 4px black'", ele);
				Thread.sleep(400);
		        js.executeScript("arguments[0].style.border=''", ele);
	        }
        }
        catch(Exception e)
        {
        	
        }
	}
	
	/**
	 * To Set Text into Web ELement and Escape. Mostly this method used for calender applications
	 * @param by		-- get element reference
	 * @param strValue -- TestData
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */
	protected static boolean setTextAndEscape(By by,String Value,WebDriver driver)
	{
		boolean status = false;
		try
		{
			highlight(by, driver);
			driver.findElement(by).click();
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(Value);
			String webvalue = driver.findElement(by).getAttribute("value");
			driver.findElement(by).sendKeys(Keys.ESCAPE);
			Thread.sleep(500);
			if (webvalue.equalsIgnoreCase(Value))
			{
				status = true;
			}
		}
		catch(Exception e)
		{
			status = false;
		}		
		return status;
	}
	/**
	 * To Perform MoseHover on Web Element
	 * @param by		-- get element reference
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */
	protected static boolean mouseHover(By by,WebDriver driver)
	{
		boolean stepStatus;
		try
		{
			Actions a1 = new Actions(driver);
			a1.moveToElement(driver.findElement(by));
			a1.build().perform();
			stepStatus = true;
		}
		catch(Exception e)
		{
			stepStatus= false;
		}
		return stepStatus;
	}
	
	
	/**
	 * To Perform Right Click or To get Pop Up Window
	 * @param by		-- get element reference
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */
	protected static boolean rightClick(By by,WebDriver driver)
	{
		boolean stepStatus;
		try
		{
			WebElement ele = driver.findElement(by);
			Actions action= new Actions(driver);
			action.contextClick(ele).build().perform();
			stepStatus = true;
		}
		catch(Exception e)
		{
			stepStatus = false;
		}		
		return stepStatus;
	}
	
	/**
	 * To Perform drag and drop Operation on Element
	 * @param by		-- get element reference
	 * @param StrDropXpath -- Xpath of the Destination WebElement
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */	
	protected static boolean dragAndDrop(String StrDragXpath,String StrDropXpath,WebDriver driver)
	{
		boolean stepStatus;
		try
		{
			WebElement drag = driver.findElement(By.xpath(StrDragXpath));
			WebElement drop = driver.findElement(By.xpath(StrDropXpath));
			Actions action = new Actions(driver);
			action.moveToElement(drag).dragAndDrop(drag, drop).build().perform();
			stepStatus = true;
		}
		catch(Exception e)
		{
			stepStatus = false;
		}		
		return stepStatus;
	}
	
	/**
	 * To Switch to a Frame on Window.
	 * @param by		-- get  reference
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */	

	protected static WebDriver switchToframe(By by,WebDriver driver)
	{
		try
		{
			WebElement frameref = driver.findElement(by);
			driver.switchTo().frame(frameref);
		}
		catch(Exception e)
		{
		}	
		return driver;
	}
	/**
	 * To Switch to a Window Based on Title
	 * @param  StrTitle		--	Title of Window.
	 * @param driver -- driver Reference
	 * @return -- true/false
	 * 
	 */	
	protected static WebDriver switchToWindowByTitle(String StrTitle,WebDriver driver)
	{
		try
		{
			Set<String> allhandles = driver.getWindowHandles();
			for(String h1:allhandles)
			{
				driver.switchTo().window(h1);
				String CurrentURL = driver.getTitle();
				if (CurrentURL.contains(StrTitle))
				{
					break;
				}
			}
		}
		catch(Exception e)
		{
		}	
		return driver;
	}
	/**
	 * To Switch to a window based on URL
	 * @param StrURL  	-- URL of the Window to Switch	
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 * 
	 */		
	protected static WebDriver switchToWindowByURL(String StrURL,WebDriver driver)
	{

		try
		{
			Set<String> allhandles = driver.getWindowHandles();
			for(String h1:allhandles)
			{
				driver.switchTo().window(h1);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(StrURL))
				{
					break;
				}
			}
		}
		catch(Exception e)
		{

		}	
		return driver;
	}
	/**
	 * To Close Window Based on Window Title
	 * @param StrTitle	-- Window Title which you want to Close
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 * 
	 */			
	protected static boolean closeWindowByTitle(String StrTitle,WebDriver driver)
	{
		boolean stepStatus = false;
		try
		{
			Set<String> allhandles = driver.getWindowHandles();
			for(String h1:allhandles)
			{
				driver.switchTo().window(h1);
				String CurrentURL = driver.getTitle();
				if (CurrentURL.contains(StrTitle))
				{
					driver.close();
					stepStatus = true;
					break;
				}
			}
		}
		catch(Exception e)
		{
			stepStatus = false;
		}	
		return stepStatus;
	}
	/**
	 * To Close Window Based on URL
	 * @param StrURL	-- URL of Window You want to close.
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 * 
	 */	
	protected static boolean closeWindowByURL(String StrURL,WebDriver driver)
	{
		boolean stepStatus = false;
		try
		{
			Set<String> allhandles = driver.getWindowHandles();
			for(String h1:allhandles)
			{
				driver.switchTo().window(h1);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(StrURL))
				{
					driver.close();
					stepStatus = true;
					break;
				}
			}
		}
		catch(Exception e)
		{
			stepStatus = false;
		}	
		return stepStatus;
	}
	
	/**
	 * To set Max TimeOut For Driver Instance.
	 * @param TimeInsec -- number of seconds to wait.
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 * 
	 */	
	protected static WebDriver SetImplicitWait(int TimeInSec,WebDriver driver)
    {
        try
        {
        	driver.manage().timeouts().implicitlyWait(TimeInSec, TimeUnit.SECONDS);
        }
        catch (Exception e)
        {
        }
        return driver;
    }
	
	
	/**
	 * To wait for a Specified Time Duration.(in Seconds)
	 * @param TimeInsec -- number of seconds to wait.
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 * 
	 */	
	protected static boolean wait(int timeInSec)
	{
		boolean stepStatus;
		try
		{
			Thread.sleep(timeInSec*1000);
			stepStatus = true;
		}
		catch(Exception e)
		{
			stepStatus = false;
		}		
		return stepStatus;
	}
	
	
	/**
	 * To Wait Specified time Duration untile Web Element Exist on Page.
	 * @param StrXpath	-- Xpath of Web Element.
	 * @param TimeInsec -- number of seconds to wait.
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 * 
	 */	
	protected static boolean dynamicWait(By by,WebDriver driver,int waittimeinsec)
	{
			boolean status = false;
			int counter = 0;
			while(counter<=waittimeinsec)
			{
				try
				{
					driver.findElement(by);
					status = true;
					break;
				}
				catch(Exception e)
				{
					try 
					{
						Thread.sleep(1000);
					} catch (Exception e1) 
					{
						
					}
					counter = counter+ 1;
				}
			 }
			 if(counter>waittimeinsec)
			 {
				 status = false;
			 }
			 return status;
			
	}


	/**
	 * To upload File based on .exe file
	 * @param exeFileName	-- Name of the File to upload.
	 * @param exeFilePath	-- Path of the File where it Located.
	 * @return -- true/false
	 * 
	 */	
	protected static boolean AutoITFileUpload(String exeFileName,String Filepath)
    {
        Boolean stepStatus = true;
        try
        {
        	Runtime.getRuntime().exec("AuotITFiles\\" + exeFileName + ".exe" + " " + Filepath);
        }
        catch (Exception e)
        {
            stepStatus = false;
        }
        return stepStatus;
    }
	/**
	 * To Upload file Based on Path
	 * @param FilePath	-- Path of File where it is located.
	 * @return -- true/false
	 * 
	 */	
	protected static boolean RobotKeysFileUpload(String Filepath)
	{
		boolean stepstatus;
		try
		{
		 	wait(2);
		   StringSelection selection = new StringSelection(Filepath);
	       Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	       clipboard.setContents(selection,selection);

			
			Robot robo = new Robot();   
			robo.keyPress(KeyEvent.VK_CONTROL);
	     	robo.keyPress(KeyEvent.VK_V);
	      	robo.keyRelease(KeyEvent.VK_V);
	      	robo.keyRelease(KeyEvent.VK_CONTROL);

	  		wait(2);
	      	robo.keyPress(KeyEvent.VK_ENTER);
	      	robo.keyRelease(KeyEvent.VK_ENTER);
	    	robo.keyPress(KeyEvent.VK_ENTER);
	      	robo.keyRelease(KeyEvent.VK_ENTER);
	      	stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	/**
	 * To Verify alert Exist.
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 * 
	 */	
	protected static boolean AlertExist(WebDriver driver)
	{
		boolean stepstatus;
		try
		{
		 	driver.switchTo().alert();
	      	stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	/**
	 * To verify alert exist after particular time instance.
	 * @param TimeInsec -- number of seconds to wait.
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 * 
	 */	
	protected static boolean WaitAlertExistence(int TimeInSec,WebDriver driver)
	{
		boolean stepstatus = false;
		int counter = 0;
		while(stepstatus==false && counter<TimeInSec)
		{
			try
			{
			 	driver.switchTo().alert();
		      	stepstatus = true;	
			}
			catch(Exception e)
			{
				stepstatus = false;
			}
			wait(1);
			counter = counter + 1;
		}
		return stepstatus;
	}
	
	/**
	 * To get text of Alert.
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 * 
	 */	
	protected static String alertGetText(WebDriver driver)
	{
		String StrAlertText = "";
		try
		{
		 	Alert a1 = driver.switchTo().alert();
		 	StrAlertText = a1.getText();
		}
		catch(Exception e)
		{
			
		}
		return StrAlertText;
	}
	/**
	 * To accept the alert.
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 * 
	 */	
	protected static boolean acceptAlert(WebDriver driver)
	{
		boolean stepstatus;
		try
		{
		 	Alert a1 = driver.switchTo().alert();
		 	a1.accept();
	      	stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	/**
	 * To dismiss alert.
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 * 
	 */	
	protected static boolean dismissAlert(WebDriver driver)
	{
		boolean stepstatus;
		try
		{
		 	Alert a1 = driver.switchTo().alert();
		 	a1.dismiss();
	      	stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	/**
	 * To Set text from Drop down
	 * @param by -- get Element Reference
	 * @param StrValue 	--Value to be select
	 * @param driver 	-- driver Reference
	 * @return -- true/false
	 */
	protected static boolean SelectValueByText(By by,String StrValue,WebDriver driver)
	{
		boolean stepstatus;
		try
		{

			Select s=new Select(driver.findElement(by));
			s.selectByVisibleText(StrValue);
			stepstatus=true;
		}
		catch(Exception e)
		{
			stepstatus=false;
		}
		
		return stepstatus;
	}
	
	

	public static void logEvent(boolean stepstatus,String plog,String flog,WebDriver driver,boolean falgTakeScreenshot)
    {
		
		if(takeScreenshotOption.equals("TakeScreenshots for All Steps"))
		{
			falgTakeScreenshot = true;
		}
		else if(takeScreenshotOption.equals("TakeScreenshots for Failed Steps Also"))
		{
			if(!stepstatus)
			{
				falgTakeScreenshot = true;
			}
		}
		else if(takeScreenshotOption.equals("TakeScreenshots for Only Failed Steps"))
		{
			if(!stepstatus)
			{
				falgTakeScreenshot = true;
			}
			else
			{
				falgTakeScreenshot = false;
			}
		}
		
		
		
		if (falgTakeScreenshot == false)
		{
			if(stepstatus)
			{
				TestReport.log(LogStatus.PASS, plog);
				System.out.println("	<<Pass>> " + plog);
			}
			else
			{
				String ScreenShotPath = getscreenshot(driver);
				String LoggerScreenShotpath = TestReport.addScreenCapture(ScreenShotPath);
				TestReport.log(LogStatus.FAIL, flog + LoggerScreenShotpath);
				System.out.println("	<<Fail>> " + flog);
			}
		}
		else
		{
			if(stepstatus)
			{
				String ScreenShotPath = getscreenshot(driver);
				String LoggerScreenShotpath = TestReport.addScreenCapture(ScreenShotPath);
				TestReport.log(LogStatus.PASS, plog + LoggerScreenShotpath);
				System.out.println("	<<Pass>> " + plog);
			}
			else
			{
				String ScreenShotPath = getscreenshot(driver);
				String LoggerScreenShotpath = TestReport.addScreenCapture(ScreenShotPath);
				TestReport.log(LogStatus.FAIL, flog + LoggerScreenShotpath);
				System.out.println("	<<Fail>> " + flog);
			}
		}
		Assert.assertTrue(stepstatus);
    }
	public static String getTimeStamp() 
	{
		DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
	    String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
	    DateTimeStamp = DateTimeStamp.replace(",", "");
	    DateTimeStamp = DateTimeStamp.replace(" ", "_");
	    DateTimeStamp = DateTimeStamp.replace(":", "-");
		return  DateTimeStamp;
	}
	public static String getscreenshot(WebDriver driver)
	{
		  try
		  {
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
			StackTraceElement stackTraceElement = stackTraceElements[3];
			String CurrentTestCase = stackTraceElement.getMethodName();
			CurrentTestCase = CurrentTestCase.replace(".java", "");
				
			String ScreenshotName;
			DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
			String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
			DateTimeStamp = DateTimeStamp.replace(",", "");
			DateTimeStamp = DateTimeStamp.replace(" ", "_");
			DateTimeStamp = DateTimeStamp.replace(":", "_");
			ScreenshotName =  CurrentTestCase + "_"+ DateTimeStamp;
			
			TakesScreenshot ts =(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String Dest = ScreenshotsFolderPath + "//" + ScreenshotName + ".png";
			File destination = new File(Dest);
			FileUtils.copyFile(source, destination);
			return Dest;
		  }
		  catch(Exception e)
		  {
			  return e.getMessage();
		  }
	}

	public static String createresultsfolder() 
	{
		DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
	    String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
	    DateTimeStamp = DateTimeStamp.replace(",", "");
	    DateTimeStamp = DateTimeStamp.replace(" ", "_");
	    DateTimeStamp = DateTimeStamp.replace(":", "-");
	    ResultsFolderPath = System.getProperty("user.dir") + "//" + ResultsFolderPath;
		File dir = new File(ResultsFolderPath + "//" +  DateTimeStamp);
		dir.mkdir();
		File dir2 = new File(ResultsFolderPath + "//" +  DateTimeStamp + "//Screenshots");
		dir2.mkdir();
		return ResultsFolderPath + "//" + DateTimeStamp;
	}
}