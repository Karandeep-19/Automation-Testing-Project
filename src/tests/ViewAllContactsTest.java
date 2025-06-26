package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ContactListPage;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class ViewAllContactsTest extends BaseTest {

    @Test
    public void testViewAllContacts() throws IOException {
        ContactListPage listPage = new ContactListPage(driver);
        listPage.openContactList();

        assert driver.getPageSource().contains("Contacts List");

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("Screenshots/TC_ViewAllContacts.png"));
    }
}