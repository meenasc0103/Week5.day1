package testcase;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public ChromeDriver driver;
	@Parameters({"Url","username","password"})
	//@Test(invocationCount=3,threadPoolSize=3)
@BeforeMethod
	public void precondition() {
		
			WebDriverManager.chromedriver().setup();
			//after declaring the driver globally need to chromeDriver alone 
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
	}
	
@AfterMethod
		public void postcondition()
		{
			driver.close();
		}
}
