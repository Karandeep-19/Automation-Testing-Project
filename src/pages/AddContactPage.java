package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContactPage {
    WebDriver driver;

    public AddContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterContactDetails(String firstName, String lastName, String email) {
        driver.findElement(By.name("addr_first_name")).sendKeys(firstName);
        driver.findElement(By.name("addr_last_name")).sendKeys(lastName);
        driver.findElement(By.name("addr_email_1")).sendKeys(email);
    }

    public void saveContact() {
        driver.findElement(By.name("submit")).click();
    }
}