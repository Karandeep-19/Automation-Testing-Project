package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditContactPage {
    WebDriver driver;

    public EditContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void editEmail(String newEmail) {
        driver.findElement(By.name("addr_email_1")).clear();
        driver.findElement(By.name("addr_email_1")).sendKeys(newEmail);
    }

    public void saveContact() {
        driver.findElement(By.name("submit")).click();
    }
}