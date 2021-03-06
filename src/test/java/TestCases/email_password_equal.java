package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.HomePage;

public class email_password_equal {
	public static WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	@BeforeTest
	public void setup() {
		// creates a toggle for the given test, adds all log events under it

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Reporter.log("Web browser is opened");

	}

	@Test
	public void testcase() throws Exception {
		driver.manage().window().maximize();
		Reporter.log("Browser is Maximized");
		driver.get("http://testingtaritas.anatomysuite.com/");
		Reporter.log("Navigating to the URL");

		HomePage testCases = new HomePage(driver);

		testCases.setEmailAdress("prankur.pandey@taritas.com");
		Reporter.log("Entering email Id");
		testCases.setPassword("Prankur@1");
		Reporter.log("Entering Correct Password");
		testCases.HitLogin();
		Reporter.log("Clicked on LogIn");
	}

	@AfterTest
	public void testdown() {
		driver.close();
		driver.quit();
	}
}
