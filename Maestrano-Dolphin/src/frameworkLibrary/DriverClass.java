package frameworkLibrary;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.apache.commons.io.FileUtils;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.relevantcodes.extentreports.ExtentReports;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class DriverClass extends GlobalVariable implements IAnnotationTransformer,ITestListener
{
	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation iAno, Class testClass, Constructor testConstructor, Method method) 
	{
		String TestCaseName = method.getDeclaringClass().getSimpleName();
		boolean TestCaseExecutionStatus = ExcelLibrary.getExecuteStatus(TestCaseName);
		if(TestCaseExecutionStatus == true)
		{
			int priority = ExcelLibrary.getPriority(TestCaseName);
			String Description = ExcelLibrary.getDescription(TestCaseName);
			
			iAno.setEnabled(true);
			iAno.setPriority(priority);
			iAno.setDescription(Description);
		}
		else
		{
			iAno.setEnabled(false);
		}
	}
	
	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("Execution Started");
		CurrentResultsFolder = WebLibrary.createresultsfolder();
		ScreenshotsFolderPath = CurrentResultsFolder + "\\Screenshots";
		ResulthtmlPath = CurrentResultsFolder + "\\Summary.html";
		ExecutedFromXMl = true;
		report = new ExtentReports(ResulthtmlPath, true);
		highlightelement = ExcelLibrary.getHighlightStatus();
		takeScreenshotOption = ExcelLibrary.getScreenshotOPtion();
		killExcel();
		ExcelLibrary.loadCommonData();
		try
		{
			record1=new ATUTestRecorder(CurrentResultsFolder , "RecordVideo", false);
			record1.start();
		}
		catch(Exception e)
		{
			System.out.println("Unable to start recording");
		}
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("");
		System.out.println("");
		String TestCaseName = result.getMethod().getRealClass().getSimpleName();
		System.out.println("Start: " + TestCaseName);
		TestReport = report.startTest(TestCaseName, result.getMethod().getDescription());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String TestCaseName = result.getMethod().getRealClass().getSimpleName();
		System.out.println("End: " + TestCaseName);
		report.endTest(TestReport);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String TestCaseName = result.getMethod().getRealClass().getSimpleName();
		System.out.println("End: " + TestCaseName);
		report.endTest(TestReport);
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String TestCaseName = result.getMethod().getRealClass().getSimpleName();
		System.out.println("End: " + TestCaseName);
		report.endTest(TestReport);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		String TestCaseName = result.getMethod().getRealClass().getSimpleName();
		System.out.println("End: " + TestCaseName);
		report.endTest(TestReport);
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Execution Finish");
		report.close();	
		try {
			record1.stop();
		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File srcDir = new File(CurrentResultsFolder);
		File destDir = new File("Results\\LastRun");
		
		try 
		{
			FileUtils.cleanDirectory(destDir);
			FileUtils.copyDirectory(srcDir, destDir);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void SetUp()
	{
		if(ExecutedFromXMl==false)
		{
			System.out.println("Execution Start");
			CurrentResultsFolder = WebLibrary.createresultsfolder();
			ScreenshotsFolderPath = CurrentResultsFolder + "\\Screenshots";
			ResulthtmlPath = CurrentResultsFolder + "\\Summary.html";
			ExecutedFromXMl = true;
			report = new ExtentReports(ResulthtmlPath, true);
			highlightelement = ExcelLibrary.getHighlightStatus();
			takeScreenshotOption = ExcelLibrary.getScreenshotOPtion();
			killExcel();
			ExcelLibrary.loadCommonData();
			try
			{
				record1=new ATUTestRecorder(CurrentResultsFolder , "RecordVideo", false);
				record1.start();
			}
			catch(Exception e)
			{
				System.out.println("Unable to start recording");
			}
			
			
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
			StackTraceElement stackTraceElement = stackTraceElements[2];
			String TestCaseName = stackTraceElement.getFileName().replace(".java", "");
			System.out.println("");
			System.out.println("");
			System.out.println("Start: " + TestCaseName);
			TestReport = report.startTest(TestCaseName, ExcelLibrary.getDescription(TestCaseName));
		}
	}
	public void TearDown()
	{
		if(ExecutedFromXMl==false)
		{
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
			StackTraceElement stackTraceElement = stackTraceElements[2];
			String TestCaseName = stackTraceElement.getFileName().replace(".java", "");
			System.out.println("End: " + TestCaseName);
			report.endTest(TestReport);
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Execution Finish");
			report.close();	
			try {
				record1.stop();
			} catch (ATUTestRecorderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File srcDir = new File(CurrentResultsFolder);
			File destDir = new File("Results\\LastRun");
			
			try 
			{
				FileUtils.cleanDirectory(destDir);
				FileUtils.copyDirectory(srcDir, destDir);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public static void killExcel()
	{
		    try 
		    {
		        Runtime.getRuntime().exec("taskkill /f /t /IM EXCEL.EXE");
		        Thread.sleep(1000);
		    }
		    catch (Exception ex) 
		    {
		       
		    }
	}
}
