package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPOM2 {
	private WebDriver driver; 
	
	public LogoutPOM2(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className ="oxd-userdropdown-name")
	private WebElement Dropdown; 
	
	@FindBy(xpath ="//*[text()='Logout']")
	private WebElement Logout;
	
	public void Drop() {
		Dropdown.click();
	}
	public void Log() {
		Logout.click();
	}
	
	
}
