import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import pages.AddContactPage;


public class AddAddressTest extends BaseClass {
	
	
	@Parameters({"FireFoxKey", "FireFoxPath"})
	 @BeforeMethod
	    
	    public void setup(String FireFoxKey, String FireFoxPath) {
		Launch(FireFoxKey, FireFoxPath);
	        driver.manage().window().maximize();
	        driver.get("http://localhost/addressbook/newEntry.php");
	    }
	@AfterMethod
    public void quit() {
		driver.close();
    }
	
	  
	  @Test public void testAddAddressFriend() throws IOException { //Valid Test Case
	

	  WebElement addrTypeDrpDwn = driver.findElement(By.id("addr_type"));

		Select s = new Select(addrTypeDrpDwn);
		List<WebElement> addrList = s.getOptions();

		for (WebElement element : addrList) {
			System.out.println(element.getText());
		}

		s.selectByVisibleText("Friend");
		
	  driver.findElement(By.id("addr_first_name")).sendKeys("Godly");
	  
	  driver.findElement(By.id("addr_last_name")).sendKeys("Koshy");
	  driver.findElement(By.id("addr_addr_line_1")).sendKeys("HouseName(h)");
      driver.findElement(By.id("addr_addr_line_2")).sendKeys("");
      driver.findElement(By.id("addr_addr_line_3")).sendKeys("");

      driver.findElement(By.id("addr_city")).sendKeys("City");
      driver.findElement(By.id("addr_region")).sendKeys("State");
      driver.findElement(By.id("addr_country")).sendKeys("India");
      driver.findElement(By.id("addr_post_code")).sendKeys("");
	  driver.findElement(By.id("addr_email_1")).sendKeys(
	  "godly@fanshawemail.com");
	  WebElement addrPH1DrpDwn = driver.findElement(By.id("addr_phone_1_type"));

		Select ph = new Select(addrPH1DrpDwn); // Selecting PhNOtype from DropDown
		List<WebElement> phNoTypeList = ph.getOptions();

		for (WebElement element : phNoTypeList) {
			System.out.println(element.getText());
		}
		ph.selectByVisibleText("Mobile");
	  driver.findElement(By.id("addr_phone_1")).sendKeys("1234466767");
	  driver.findElement(By.id("submit_button")).click();
	  
	  }
	  
	  @Test public void testAddAddressFamily() throws IOException { // Testing address type dropdown
		  //driver.get("http://localhost/addressbook/newEntry.php");

		  WebElement addrTypeDrpDwn = driver.findElement(By.id("addr_type"));

			Select s = new Select(addrTypeDrpDwn);
			List<WebElement> addrList = s.getOptions();

			for (WebElement element : addrList) {
				System.out.println(element.getText());
			}

			s.selectByVisibleText("Family");
		  driver.findElement(By.id("addr_first_name")).sendKeys("Elon");
		  
		  driver.findElement(By.id("addr_last_name")).sendKeys("Musk");
		  driver.findElement(By.id("addr_email_1")).sendKeys(
		  "Musk@space.com");
		  
		  driver.findElement(By.id("addr_phone_1")).sendKeys("1116661111");
		  driver.findElement(By.id("submit_button")).click();
		  
		  }
	  
	  @Test public void testAddAddressBusiness() throws IOException { // Testing Dropdown for addr_type and The PhoneNumber1  
		  //driver.get("http://localhost/addressbook/newEntry.php");

		  WebElement addrTypeDrpDwn = driver.findElement(By.id("addr_type"));

			Select s = new Select(addrTypeDrpDwn);
			List<WebElement> addrList = s.getOptions();

			for (WebElement element : addrList) {
				System.out.println(element.getText());
			}

			s.selectByVisibleText("Business");
		  driver.findElement(By.id("addr_first_name")).sendKeys("Karandeep");
		  
		  driver.findElement(By.id("addr_last_name")).sendKeys("Singh");
		  driver.findElement(By.id("addr_email_1")).sendKeys(
		  "karandeep@mail.com");
		  WebElement addrPH1DrpDwn = driver.findElement(By.id("addr_phone_1_type"));

			Select ph = new Select(addrPH1DrpDwn);
			List<WebElement> phNoTypeList = ph.getOptions();

			for (WebElement element : phNoTypeList) {
				System.out.println("PhnoList\n-----\n"+element.getText());
			}
			ph.selectByVisibleText("Work");
		  driver.findElement(By.id("addr_phone_1")).sendKeys("1119991110");
		  driver.findElement(By.id("submit_button")).click();
		  
		  }
	  
	  @Test public void testAddAddressOther() throws IOException { //
		  //driver.get("http://localhost/addressbook/newEntry.php");

		  WebElement addrTypeDrpDwn = driver.findElement(By.id("addr_type"));

			Select s = new Select(addrTypeDrpDwn);
			List<WebElement> addrList = s.getOptions();

			for (WebElement element : addrList) {
				System.out.println(element.getText());
			}

			s.selectByVisibleText("Other");
		  driver.findElement(By.id("addr_first_name")).sendKeys("Amandeep");
		  
		  driver.findElement(By.id("addr_last_name")).sendKeys("Kaur");
		  driver.findElement(By.id("addr_addr_line_1")).sendKeys("Area-51");
		  driver.findElement(By.id("addr_email_1")).sendKeys(
		  "Kaur@mail.com");
		  

		  
		  driver.findElement(By.id("addr_phone_1")).sendKeys("1111111111");
		  driver.findElement(By.id("submit_button")).click();
		  successCheck(); // success check using assert true.
		  }
	  
	  @Test
		void addNewEntryValidationEmptyField() { // performin validation using assertions

			driver.findElement(By.id("addr_first_name")).sendKeys("Raiyan");
			
			driver.findElement(By.id("submit_button")).click();

			//Forcefully making the test fail, if success message is present
			String actualMessage = driver.findElement(By.tagName("h2")).getText();

			if (actualMessage.contains("The new address book entry was added successfully")) {//making the test fail due to null submission worked
				Assertions.fail("Test failed: Validation is Not there. Form accepted invalid input data. !");
			} else {
				// Optionally check for an error message or just assume it failed as expected
				System.out.println("Validation worked — success message not shown.");
			}
						
		}
	  
	  @Test
		void addNewEntryWithInvalidEmailField() { // performin validation using assertions
			driver.findElement(By.id("addr_first_name")).sendKeys("Kanon");
			driver.findElement(By.id("addr_last_name")).sendKeys("Nikon");
			  driver.findElement(By.id("addr_email_1")).sendKeys(
			  "Kanon.com");

				Assertions.fail("Test failed: Form accepted invalid addr_email_1 input data. Validation is missing!");
			driver.findElement(By.id("submit_button")).click();
			  // Invalid Email Field and rest all required field empty!..
 
			//Forcefully making the test fail, if success message is present
			String actualMessage = driver.findElement(By.tagName("h2")).getText();
			String successMessage = "The new address book entry was added successfully";

			if (actualMessage.contains(successMessage)) {//making the test fail due to null submission worked
				System.out.println("Address updated with invalid mail so making the test fail");
				
				
			} else {
				// Optionally check for an error message or just assume it failed as expected
				System.out.println("Validation worked — success message not shown.");
			}
						
		}

	  
	  public void successCheck() { // checking the address form got submitted using assertion method
			String success = driver.findElement(By.cssSelector("body > form > div > h2")).getText();
			assertTrue(success.contains("successfully"));
		}
	  
	  
	 
	
}
