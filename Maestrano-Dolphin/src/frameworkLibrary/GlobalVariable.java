package frameworkLibrary;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import atu.testrecorder.ATUTestRecorder;

public class GlobalVariable 
{
	public static ExtentReports report;
	public static ExtentTest TestReport;
	public static String CurrentResultsFolder;
	public static String ResultsFolderPath= "Results";
	public static String ScreenshotsFolderPath;
	public static String currentbrowser;
	public static String ResulthtmlPath; 
	public static boolean ExecutedFromXMl = false;
	public static boolean highlightelement = false;
	public static String takeScreenshotOption = "TakeScreenshots for the Specified Steps";
	public static Map<String, String> commondata = new HashMap<String,String>();
	ATUTestRecorder record1;
}
