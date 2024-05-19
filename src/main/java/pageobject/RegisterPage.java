package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class RegisterPage extends AbstractComponent {
	WebDriver driver;

	
	public RegisterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='First name']")
	 WebElement firstName;
	 
	 @FindBy(xpath="//input[@placeholder='Last Name']")
	 WebElement lastName;
	 
	 @FindBy(xpath="//input[@placeholder='User name']")
	 WebElement userName;

	 @FindBy(xpath="//input[@placeholder='Password']")
	 WebElement Password;
	 

	 @FindBy(xpath="//input[@placeholder='Confirm Password']")
	 WebElement confirmPassword;
	 
	 @FindBy(xpath="//input[@value='Male']")
	 WebElement checkbox;
	 @FindBy(xpath="//span[normalize-space()='Register']")
	 WebElement register;
	 
	 public void deatil(String name,String sirname,String username,String password,String confirmpassword) throws InterruptedException
	 {
		 firstName.sendKeys(name);
		 lastName.sendKeys(sirname);
		 userName.sendKeys(username);
		 Password.sendKeys(password);
		 scrollDown(driver);
		 confirmPassword.sendKeys(confirmpassword);
		 Thread.sleep(5000);
		 checkbox.click();
		 register.click();
	 }

	
}
