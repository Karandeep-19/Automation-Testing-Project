package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ContactListPage;
import pages.ViewContactPage;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class ViewContactTest extends BaseTest {

    @Test
    public void testViewContact() throws IOException {
        ContactListPage listPage = new ContactListPage(driver);
        listPage.openContactList();
        listPage.clickViewFirstContact();

        ViewContactPage viewPage = new ViewContactPage(driver);
        String name = viewPage.getFullName();
        assert name != null && !name.isEmpty();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("Screenshots/TC_ViewContact.png"));
    }
}