//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//
//public class AddressModelClass {
//    WebDriver driver;
//    
//    String addr_type;
//    String firstName;
//    String lastName;
//    String addr_addr_line_1;
//    String addr_addr_line_2;
//    String addr_addr_line_3;
//    String addr_city;
//    String addr_region;
//    String addr_country;
//    String addr_post_code;
//    String email1;
//    String email2;
//    String email3;
//    String phone1;
//    String phone2;
//    String phone3;
//
//    public AddressModelClass(WebDriver driver) {
//        this.driver = driver;
//        this.addr_type = addr_type;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.addr_addr_line_1 = addr_addr_line_1;
//        this.addr_addr_line_2 = addr_addr_line_2;
//        this.addr_addr_line_3 = addr_addr_line_3;
//        this.addr_city = addr_city;
//        this.addr_region = addr_region;
//        this.addr_country = addr_country;
//        this.addr_post_code = addr_post_code;
//        this.email1 = email1;
//        this.email2 = email2;
//        this.email3 = email3;
//        this.phone1 = phone1;
//        this.phone2 = phone2;
//        this.phone3 = phone3;
//        
//    }
//
//    public void enterContactDetails(
//            
//    ) {
//        driver.findElement(By.cssSelector("body > doctype > ul > li:nth-child(2) > a")).click();
//        
//        WebElement dropDown = driver.findElement(By.id("addr_type"));
//
//		Select s = new Select(dropDown);
//		List<WebElement> elements = s.getOptions();
//
//		for (WebElement element : elements) {
//			System.out.println(element.getText());
//		}
//
//		s.selectByVisibleText("addr_type");
//        
//        driver.findElement(By.id("addr_type")).sendKeys(addr_type != null ? addr_type : "");
//        driver.findElement(By.id("addr_first_name")).sendKeys(firstName != null ? firstName : "");
//        driver.findElement(By.id("addr_last_name")).sendKeys(lastName != null ? lastName : "");
//
//        driver.findElement(By.id("addr_addr_line_1")).sendKeys(addr_addr_line_1 != null ? addr_addr_line_1 : "");
//        driver.findElement(By.id("addr_addr_line_2")).sendKeys(addr_addr_line_2 != null ? addr_addr_line_2 : "");
//        driver.findElement(By.id("addr_addr_line_3")).sendKeys(addr_addr_line_3 != null ? addr_addr_line_3 : "");
//
//        driver.findElement(By.id("addr_city")).sendKeys(addr_city != null ? addr_city : "");
//        driver.findElement(By.id("addr_region")).sendKeys(addr_region != null ? addr_region : "");
//        driver.findElement(By.id("addr_country")).sendKeys(addr_country != null ? addr_country : "");
//        driver.findElement(By.id("addr_post_code")).sendKeys(addr_post_code != null ? addr_post_code : "");
//
//        driver.findElement(By.id("addr_email_1")).sendKeys(email1 != null ? email1 : "");
//        driver.findElement(By.id("addr_email_2")).sendKeys(email2 != null ? email2 : "");
//        driver.findElement(By.id("addr_email_3")).sendKeys(email3 != null ? email3 : "");
//
//        driver.findElement(By.id("addr_phone_1")).sendKeys(phone1 != null ? phone1 : "");
//        driver.findElement(By.id("addr_phone_2")).sendKeys(phone2 != null ? phone2 : "");
//        driver.findElement(By.id("addr_phone_3")).sendKeys(phone3 != null ? phone3 : "");
//    }
//
//
//    public void saveContact() {
//    	
//        driver.findElement(By.id("submit")).click();
//    }
//}