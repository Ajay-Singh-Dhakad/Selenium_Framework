/**
 * 
 */
package HomePage_Karnataka_Tourism;

import java.io.FileInputStream;
import java.util.Properties;

import org.bouncycastle.math.ec.tools.TraceOptimizer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.pom.Homepage;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/**
 * @author Ajay
 *
 */
public class HomePage_Karnataka {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
    private Homepage Karnataka;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.EDGE);
		Karnataka=new Homepage(driver);
		baseUrl = properties.getProperty("baseURL1");
		driver.get(baseUrl);
	}
	@Test(priority = 0,enabled =true)
	public void TC_001(){
		Karnataka.Dropd();
	}
	@Test(priority = 1,enabled = true)
	public void TC_003(){
		Karnataka.Carousel();
	}
	@Test(priority = 2,enabled =true)
	public void TC_015(){
		Karnataka.PlanYourTrip();
	}
	
	@Test(priority = 7,enabled =true)
	public void TC_020(){
		Karnataka.blogs();
		Karnataka.Listblogs();
	}
	
	@Test(priority = 4,enabled =true)
	public void TC_018() throws InterruptedException{
		
		Karnataka.Healths();
	}
	
	@Test(priority = 5,enabled = true)
	public void TC_022() throws InterruptedException{
	
		Karnataka.Photos();
	}

	@Test(priority = 6,enabled =true)
	public void TC_024() throws InterruptedException {
		
		Karnataka.social();
	}
	@Test(priority = 3,enabled =true)
	public void TC_014() throws InterruptedException {
		
	Karnataka.Exploree();
	}
	@Test(priority =8,enabled =true)
	public void TC_002(){
		Karnataka.Dropdownn();
	}
	
	
	
}
