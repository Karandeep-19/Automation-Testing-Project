package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ContactListPage;
import pages.EditContactPage;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class EditContactTest extends BaseTest {

    @Test
    public void testEditContact() throws IOException {
        ContactListPage listPage = new ContactListPage(driver);
        listPage.openContactList();
        listPage.clickEditFirstContact();

        EditContactPage editPage = new EditContactPage(driver);
        editPage.editEmail("new.email@example.com");
        editPage.saveContact();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("Screenshots/TC_EditContact.png"));
    }
}