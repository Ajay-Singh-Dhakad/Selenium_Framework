package com.training.pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage {
	private WebDriver driver; 
	
	public  Homepage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="lang_choice_polylang-9")
	private WebElement Dropdown;
	
	@FindBy(id ="slider-24-slide-125-layer-1")
	private WebElement Carousel;
	
	@FindBy(xpath = "//h2[text()='EXPERIENCE KARNATAKA']")
	private WebElement Trip;
	
	@FindBy(xpath = "(//a[@id='map-btn-id'])[1]")
	private WebElement Explore;
	
	@FindBy(id = "nav-menu-item-127114")
	private WebElement Blogs;
	
	@FindBy(id = "cn-accept-cookie")
	private WebElement Accept;
	
	@FindBy(xpath  = "(//a[@id='adv-btn-id'])[2]")
	private WebElement Health;
	
	@FindBy(xpath  = "(//a[@id='dest-btn-id'])[2]")
	private WebElement Gallary;
	
	@FindBy(xpath  = "//h4[@class='entry-title mkdf-post-title']/a")
	private List<WebElement> ListBlogs;
	
	@FindBy(xpath  = "//img[@src='https://karnatakatourism.org/wp-content/uploads/2022/08/Instagram.png']")
	private WebElement Social;
	
	public void Dropdownn() {
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true)",Dropdown);
		Select Dropd=new Select(Dropdown);
		Dropd.selectByIndex(0);
	
		
	}
	

	public void Dropd() {

		Dropdown.isDisplayed();
	}
	public void PlanYourTrip() {
		Trip.isDisplayed();
		String t=Trip.getText();
		System.out.println(t);
	}
	public void Carousel() {
		String Carousl=Carousel.getText();
		System.out.println(Carousl);
		
	}
	public void blogs() {
//		 Set<String> id=driver.getWindowHandles();
//	     Iterator<String> itr=id.iterator();
//	     String ParentId=itr.next();
		  Blogs.click();
//		  driver.switchTo().window(ParentId);
//		  driver.navigate().refresh();
		  
			
		
	}
	public void Listblogs() {
		for(int i=0;i<ListBlogs.size();i++) {
		String List=ListBlogs.get(i).getText();
		System.out.println(List);
	
		}
			
		}
	
	public void Healths() throws InterruptedException {
		
		 Set<String> id=driver.getWindowHandles();
	     Iterator<String> itr=id.iterator();
	     String ParentId=itr.next();
	    

	     String Actual="https://karnatakatourism.org/safety-guidelines-for-tourists/";
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true)", Health);
		Thread.sleep(1000);
		 Health.click();
		 Assert.assertEquals(Actual,"https://karnatakatourism.org/safety-guidelines-for-tourists/");
	     driver.switchTo().window(ParentId);
	     driver.navigate().refresh();
	  
		
	}
	public void Photos() throws InterruptedException {
	
		 Set<String> id=driver.getWindowHandles();
	     Iterator<String> itr=id.iterator();
	     String ParentId=itr.next();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",Gallary);
		Thread.sleep(3000);
		Gallary.click();
		String Actual="https://karnatakatourism.org/gallery/";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(Actual, "https://karnatakatourism.org/gallery/");
		softAssert.assertAll();
		
	     
		driver.switchTo().window(ParentId);
		 driver.navigate().refresh();
	
		
		
		
		
	}
	public void social() throws InterruptedException {
		 Set<String> id=driver.getWindowHandles();
	     Iterator<String> itr=id.iterator();
	     String ParentId=itr.next();
	   
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true)", Social);
	
		 Social.click();
		 
		 driver.switchTo().window(ParentId);
		 driver.navigate().refresh();

	
		
		
	}
	
	public void Exploree() throws InterruptedException {
		
		  Set<String> id=driver.getWindowHandles();
		     Iterator<String> itr=id.iterator();
		     String ParentId=itr.next();

		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",Explore);
	
		Explore.click();	
		String Actual="https://karnatakatourism.org/tour-item/districts/";
		String Expeted="https://karnatakatourism.org/tour-item/districts/";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(Actual, Expeted);
		softAssert.assertAll();
		 driver.switchTo().window(ParentId);
		 driver.navigate().refresh();
		
	}
	
	
}
