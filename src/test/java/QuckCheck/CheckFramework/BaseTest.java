package QuckCheck.CheckFramework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseTest {
	 public WebDriver driver;
	
//	public void ScreenShot(WebDriver driver,String tname) throws IOException
//	{
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		File file=new File(System.getProperty("user.dir")+"//reports//"+tname+".png");
//		FileUtils.copyFile(source,file);
//		System.out.println("screen shot taken");
//		
//
//}
	@BeforeMethod(alwaysRun=true)
	public void launchApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	}
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"amej","Kazi","AmejKazi","amej123@A22@","amej123@A22@"}};

}
	@AfterMethod
	public void tearDown() {
		
		
		driver.quit();
	}
	
}
