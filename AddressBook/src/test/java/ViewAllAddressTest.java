
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;

public class ViewAllAddressTest extends BaseClass {

	@Parameters({"FireFoxKey", "FireFoxPath"})
	 @BeforeMethod
	    
	    public void setup(String FireFoxKey, String FireFoxPath) {
		Launch(FireFoxKey, FireFoxPath);
	        driver.manage().window().maximize();
	        driver.get("http://localhost/addressbook/index.php");
	    }
	@AfterMethod
    public void quit() {
		driver.close();
    }
	
	@Test public void testListAllAddress()throws IOException{
		  driver.findElement(By.cssSelector("body > doctype > ul > li:nth-child(1) > a"
		  )).click();}
}