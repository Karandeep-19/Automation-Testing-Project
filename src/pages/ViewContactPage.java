package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewContactPage {
    WebDriver driver;

    public ViewContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFullName() {
        return driver.findElement(By.id("contact_name")).getText();
    }
}