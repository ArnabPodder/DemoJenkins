package demoSelenium;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReportingDemo extends HtmlReporter {
	int indexSI = 1;
	public static WebDriver driver;
	public static boolean response;
	ScreenshotClass screenshotObject = new ScreenshotClass();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
	Date date = new Date();

	@BeforeTest
	public void before() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void testOne() throws IOException {

		driver.get("http://www.bbc.com/");
//		drive.get("https://www.amazon.in/");

		String screenShotLocation = "D:\\SpringBoot\\demoSelenium\\screenshot\\demoHTML-" + indexSI + "-"
				+ dateFormat.format(date) + ".png";
		System.out.println(screenShotLocation);
		screenshotObject.takeScreenShot(ReportingDemo.driver, screenShotLocation);
		Assert.assertFalse(response = true);
		if (response == true)
			updateResult(indexSI, screenShotLocation, "Pass");
		else if (response == false)
			updateResult(indexSI, screenShotLocation, "Fail");
		else
			updateResult(indexSI, screenShotLocation, "Skip");
		indexSI++;

	}

	@Test(priority = 2)
	public void testTwo() throws IOException {
		driver.get("https://www.amazon.in/");

		String screenShotLocation = "D:\\SpringBoot\\demoSelenium\\screenshot\\demoHTML-" + indexSI + "-"
				+ dateFormat.format(date) + ".png";
		System.out.println(screenShotLocation);
		screenshotObject.takeScreenShot(ReportingDemo.driver, screenShotLocation);
		Assert.assertFalse(response = false);
		if (response == true)
			updateResult(indexSI, screenShotLocation, "Pass");
		else if (response == false)
			updateResult(indexSI, screenShotLocation, "Fail");
		else
			updateResult(indexSI, screenShotLocation, "Skip");
		indexSI++;

	}

	@Test(priority = 3, dependsOnMethods = "testTwo")
	public void testThree() throws IOException {
		driver.get("http://www.flipkart.in/");

		String screenShotLocation = "D:\\SpringBoot\\demoSelenium\\screenshot\\demoHTML-" + indexSI + "-"
				+ dateFormat.format(date) + ".png";
		System.out.println(screenShotLocation);
		screenshotObject.takeScreenShot(ReportingDemo.driver, screenShotLocation);
		Assert.assertFalse(response = true);
		if (response == true)
			updateResult(indexSI, screenShotLocation, "Pass");
		else if (response == false)
			updateResult(indexSI, screenShotLocation, "Fail");
		else
			updateResult(indexSI, screenShotLocation, "Skip");
		indexSI++;
	}

	@Test(priority = 4)
	public void testFour() throws IOException {
		driver.get("http://www.youtube.com/");

		String screenShotLocation = "D:\\SpringBoot\\demoSelenium\\screenshot\\demoHTML-" + indexSI + "-"
				+ dateFormat.format(date) + ".png";
		System.out.println(screenShotLocation);
		screenshotObject.takeScreenShot(ReportingDemo.driver, screenShotLocation);
		Assert.assertFalse(response = true);
		if (response == true)
			updateResult(indexSI, screenShotLocation, "Pass");
		else if (response == false)
			updateResult(indexSI, screenShotLocation, "Fail");
		else
			updateResult(indexSI, screenShotLocation, "Skip");
		indexSI++;
	}

	@Test(priority = 5)
	public void testFive() throws IOException {
		driver.get("http://www.myntra.com/");

		String screenShotLocation = "D:\\SpringBoot\\demoSelenium\\screenshot\\demoHTML-" + indexSI + "-"
				+ dateFormat.format(date) + ".png";
		System.out.println(screenShotLocation);
		screenshotObject.takeScreenShot(ReportingDemo.driver, screenShotLocation);
		Assert.assertFalse(response = true);
		if (response == true)
			updateResult(indexSI, screenShotLocation, "Pass");
		else if (response == false)
			updateResult(indexSI, screenShotLocation, "Fail");
		else
			updateResult(indexSI, screenShotLocation, "Skip");
		indexSI++;
	}

	@AfterTest
	public void after() {
		driver.quit();
	}

}
