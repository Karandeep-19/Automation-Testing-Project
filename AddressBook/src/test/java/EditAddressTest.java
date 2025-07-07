import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditAddressTest extends BaseClass {


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
		
			@Test 
			public void editAnAddress()throws IOException{
			WebElement row = findRowByName("Amandeep");
				
				if (row != null) {
				
					WebElement editBtn = row.findElement(By.xpath(".//input[@type='submit' and @value='Edit Details']"));
					editBtn.click();   //
					System.out.println("Edit Details clicked for: Amandeep");

					// Clear and enter new values
					WebElement addrLastName = driver.findElement(By.id("addr_last_name"));
					addrLastName.clear();
					addrLastName.sendKeys("Kaur");
				
					WebElement address1 = driver.findElement(By.name("addr_addr_line_1"));
					address1.clear();
					address1.sendKeys("666 House");
					
				
					WebElement address3 = driver.findElement(By.name("addr_addr_line_3"));
					address3.clear();
					address3.sendKeys("Chandigarh");
					
					WebElement email1 = driver.findElement(By.id("addr_email_1"));
					email1.clear();
					email1.sendKeys("aman@gmail.com");
					
					WebElement addrPH1DrpDwn = driver.findElement(By.id("addr_phone_1_type"));

					Select ph = new Select(addrPH1DrpDwn);  // changing PhNO Type from the dropdown options
					List<WebElement> phNoTypeList = ph.getOptions();

					for (WebElement element : phNoTypeList) {
						System.out.println(element.getText());
					}
					ph.selectByVisibleText("Mobile");
					
					WebElement PhNO1=  driver.findElement(By.id("addr_phone_1"));
					PhNO1.clear();
					PhNO1.sendKeys("6161616161");
															
					// Save the form
					WebElement saveButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Save Address']"));
					saveButton.click();
					System.out.println("Form edited and saved successfully.");
										
				
				} else {
					System.out.println("No row found with name: Amandeep" );
				}
				
				
							
	    }
			@Test	//Performin an invalid address update with null values in the required field/
			
		public void editAddressWithNullValueTest() { // Invalid Test validation work's with null field
			WebElement row = findRowByName("Elon");
			
			if (row != null) {
			
				WebElement editBtn = row.findElement(By.xpath(".//input[@type='submit' and @value='Edit Details']"));
				editBtn.click();   //
				System.out.println("Edit Details clicked for: Karandeep");

				// Clear and enter new values
				WebElement addrLastName = driver.findElement(By.id("addr_last_name"));
				addrLastName.clear();
				addrLastName.sendKeys("Singh");
				WebElement address1 = driver.findElement(By.name("addr_addr_line_1"));
				address1.clear();
				WebElement address2 = driver.findElement(By.name("addr_addr_line_2"));
				address2.clear();
				WebElement address3 = driver.findElement(By.name("addr_addr_line_3"));
				address3.clear();
				WebElement email1 = driver.findElement(By.id("addr_email_1"));
				email1.clear();
				WebElement PhNO1=  driver.findElement(By.id("addr_phone_1"));
				PhNO1.clear();
				
								
				// Save the form
				WebElement saveButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Save Address']"));
				saveButton.click();
				
				
				String successMessage = "The address book entry was updated successfully";
				String actualMessage = driver.findElement(By.tagName("h2")).getText();
				//Forcefully making the test fail In case "required field with null" submission worked
				if (actualMessage != null && actualMessage.contains(successMessage)) {
					Assertions.fail("Test failed: Form accepted invalid input data. Validation is missing!");
					System.out.println("Form edited and Validation does not worked.");
				} else {
					
					System.out.println("Validation worked — success message not shown.");
				}
				
			
			} else {
				System.out.println("No row found with name: Karandeep" );
			}
		}
			@Test
		public void editAddressWithInvalidPhNOTest() { // validation work's with null field
			WebElement row = findRowByName("Elon");
			
			if (row != null) {
			
				WebElement editBtn = row.findElement(By.xpath(".//input[@type='submit' and @value='Edit Details']"));
				editBtn.click();   //
				System.out.println("Edit Details clicked for: Elon");

				// Clear and enter new values
				WebElement addrLastName = driver.findElement(By.id("addr_last_name"));
				addrLastName.clear();
				addrLastName.sendKeys("Musk");
				WebElement address1 = driver.findElement(By.name("addr_addr_line_1"));
				address1.clear();
				WebElement address2 = driver.findElement(By.name("addr_addr_line_2"));
				address2.clear();
				WebElement address3 = driver.findElement(By.name("addr_addr_line_3"));
				address3.clear();
				WebElement email1 = driver.findElement(By.id("addr_email_1"));
				email1.clear();
				WebElement PhNO1=  driver.findElement(By.id("addr_phone_1"));
				PhNO1.clear();
				PhNO1.sendKeys("ajd1238aas");
				Assertions.fail("Test failed: Form accepted invalid input data. Validation is missing!");
				
								
				// Save the form
				WebElement saveButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Save Address']"));
				saveButton.click();
				
				
				String successMessage = "The address book entry was updated successfully";
				String actualMessage = driver.findElement(By.tagName("h2")).getText();
				//Forcefully making the test fail In case "required field with null" submission worked
				if (actualMessage != null && actualMessage.contains(successMessage)) {
					System.out.println("Form edited and Invalid PhNo So Forced Test Fail.");
				} else {
					
					System.out.println("Validation worked — success message not shown.");
				}
				
			
			} else {
				System.out.println("No row found with name: Elon" );
			}
		}
		
		

			public WebElement findRowByName(String name) {
				List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
				for (WebElement row : rows) {
					if (row.getText().contains(name)) {
						return row;
					}
				}
				return null;
			}
		}
