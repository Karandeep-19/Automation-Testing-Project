package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class ValidationTest extends BaseTest {

    @Test
    public void testValidationError() throws IOException {
        driver.get("http://localhost/addressbook/add_contact.php");
        driver.findElement(By.name("submit")).click();  // Submit empty form

        boolean errorDisplayed = driver.getPageSource().contains("Validation Error");
        assert errorDisplayed;

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("Screenshots/TC_ValidationError.png"));
    }
}