package abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class AbstractComponent {
	WebDriver driver;
	public  AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//span[text()='Register']")
	WebElement register;
	@FindBy(xpath="//span[text()=' Login ']")
	WebElement login;
	@FindBy(xpath="//button[@ng-reflect-router-link=\"/shopping-cart\"]/child::span[4]")
	WebElement cart;
	
//	public RegisterPage register()
//	{
//		register.click();
//		RegisterPage rp= new RegisterPage(driver);
//		return rp;
//	}
	
	
	public void elementToAppear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	public void getTitle()
	{
		System.out.println(driver.getTitle());
	}
	
	public void scrollDown(WebDriver driver)
	{
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(0,700)");
	}
	public void webElementToAppear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		
	}
	

}




