package QuckCheck.CheckFramework;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobject.RegisterPage;

public class Test2 extends BaseTest {
	
	@Test(dataProvider="getData")
	@Parameters("url")
	
	public void register(String url,String name,String lastname,String username,String pd,String cpd ) throws InterruptedException
	{
		RegisterPage rp=new RegisterPage(driver);
		driver.get(url);
		rp.deatil(name, lastname, username, pd, cpd);
		Assert.assertEquals("BookCart",driver.getTitle());
	}
}
//<parameter name="url" value="https://bookcart.azurewebsites.net/register"></parameter>
