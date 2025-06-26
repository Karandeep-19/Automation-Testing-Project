package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AddContactPage;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AddContactTest extends BaseTest {

    @Test
    public void testAddContact() throws IOException {
        driver.get("http://localhost/addressbook/add_contact.php");
        AddContactPage page = new AddContactPage(driver);
        page.enterContactDetails("John", "Doe", "john.doe@example.com");
        page.saveContact();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("Screenshots/TC01_AddContact.png"));
    }
}