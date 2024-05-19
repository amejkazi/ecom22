package QuckCheck.CheckFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AppDemo {
	WebDriver driver;

	@BeforeMethod
	public void launchApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	}

	@Test(dataProvider="getData")
	public void register(String name,String sirname,String username,String password,String confirmpassword) throws InterruptedException {

		driver.get("https://bookcart.azurewebsites.net/login");
		driver.findElement(By.xpath("//span [contains(.,'Register')]")).click();
		// input[@placeholder='First name']

		driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys(name);
		// input[@placeholder='Last Name']
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(sirname);

		// input[@placeholder='User name']
		driver.findElement(By.xpath("//input[@placeholder='User name']")).sendKeys(username);
		// input[@placeholder='Password']
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		// mat-label[class*='ng-tns-c19-16']
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(confirmpassword);
		// #mat-radio-5-input
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@value='Male']")))
	
		driver.findElement(By.xpath("//input[@value='Male']")).click();
//	driver.findElement(By.cssSelector("#mat-radio-5)")).click();
		// span[normalize-space()='Register']
		driver.findElement(By.xpath("//span[normalize-space()='Register']")).click();
	String title=driver.getTitle();
	System.out.println(title);
	Assert.assertEquals("BookCart", title);
		Thread.sleep(3000);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"amej","Kazi","AmejKazi","amej123@A22@","amej123@A22@"}};

}
}
