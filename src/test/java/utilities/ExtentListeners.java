package utilities;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import test.Timesheet;

public class ExtentListeners implements ITestListener {

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

	private static ExtentReports extent = ExtentManager.createInstance("./reports/" + fileName);

	public static ExtentTest test;

	public void onTestStart(ITestResult result) {

		test = extent.createTest(
				result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName() + "()");

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "TEST CASE :- " + methodName + " PASSED";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);

	}

	public void onTestFailure(ITestResult result) {
		
		String screenshotPath = Screenshot.captureScreenshot(Timesheet.getDriver());
		test.addScreenCaptureFromPath(""+screenshotPath);
		String methodName = result.getMethod().getMethodName();
		String logText = "TEST CASE :- " + methodName + " FAILED";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.fail(m);
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "TEST CASE :- " + methodName + " SKIPPED";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		test.skip(m);
	}

	public void onFinish(ITestContext context) {
		
		if(extent != null) {
			extent.flush();
		}
		
	}

}
