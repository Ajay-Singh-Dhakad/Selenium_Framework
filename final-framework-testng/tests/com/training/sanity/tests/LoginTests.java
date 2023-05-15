package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Homepage;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM2 logoutPOM;
	private static Properties properties;
	private ScreenShot screenShot;
    private Homepage Karnataka;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.EDGE);
		loginPOM = new LoginPOM(driver);
		logoutPOM=new LogoutPOM2(driver);
		Karnataka=new Homepage(driver);
		baseUrl = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test(priority = 1,enabled = false)
	public void validLoginTest() {
		loginPOM.sendUserName("Admin");
		loginPOM.sendPassword("admin123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
	}
	@Test(priority = 2,enabled = false)
	public void Logo() throws InterruptedException {
		Thread.sleep(1000);
		logoutPOM.Drop();
		logoutPOM.Log();
	}
	@Test
	public void ClickDrop() {
		Karnataka.Dropdownn();
	}
	
}
