import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ViewAddresDetails extends BaseClass {


	@Parameters({"FireFoxKey", "FireFoxPath"})
	@BeforeMethod
    
    public void setup(String FireFoxKey, String FireFoxPath) {
	Launch(FireFoxKey, FireFoxPath);
        driver.manage().window().maximize();
        driver.get("http://localhost/addressbook/allList.php");
    }
	
	@AfterMethod
    public void quit() {
		driver.close();
    }
	
	
	@Test(dataProvider="nameList") // Parameterized testing by names Using DataProvidex
	public void vewAddressDetailsByName(String name)throws IOException{ 
		System.out.println("Address Details view Started with: "+ name);
		WebElement row = findRowByName(name);
		if (row != null) {
			WebElement viewDetailBtn = row.findElement(By.xpath(".//input[@type='submit' and @value='View Details']"));
			viewDetailBtn.click();
			System.out.println("Address Details Viewed");
		}
		else {
			System.out.println(name+"doesnot exist");
		}
		
	}
	
	 @DataProvider(name = "nameList")
	    public Object[][] provideNameList() { //parameterized testing using data provider
	        return new Object[][] {
	            {"Godly"},
	            {"Amandeep"},
	            {"Karandeep"},
	            {"Operator"}, // Checking with Address doesnot exist !
	            {"Elon"}
	            
	        };
	    }
	
	public WebElement findRowByName(String name) { // method to find the name from the list
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
		for (WebElement row : rows) {
			if (row.getText().contains(name)) {
				return row;
			}
		}
		return null;
	}
	
}
