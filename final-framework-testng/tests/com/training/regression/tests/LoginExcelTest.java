package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginExcelTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM2 logoutPOM;
	private static Properties properties;
	private ScreenShot screenShot;

@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver);
		logoutPOM=new LogoutPOM2(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
	

	@Test(priority = 1,dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot(userName);

	}
	@Test(priority = 2)
	public void Logoutd() {
		logoutPOM.Drop();
		logoutPOM.Log();
	}

}