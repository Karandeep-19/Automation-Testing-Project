package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListPage {
    WebDriver driver;

    public ContactListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openContactList() {
        driver.findElement(By.linkText("View All Contacts")).click();
    }

    public void clickEditFirstContact() {
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[last()]/a[text()='Edit']")).click();
    }

    public void clickViewFirstContact() {
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[last()]/a[text()='View']")).click();
    }
}