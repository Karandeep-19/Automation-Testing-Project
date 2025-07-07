import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
 
	public static void Launch(String FireFoxKey, String FireFoxPath) {
		System.setProperty(FireFoxKey, FireFoxPath);
        driver = new FirefoxDriver();
	}
	
	 public void takeScreenshot(String testMethodName) throws IOException{
//			System.out.println("Driver Connected: "+this.driver.toString());
			File srcFiles=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String filepath=("C:\\Users\\Admin\\eclipse-workspace\\ProjectAutomation2\\ScreenShots\\"+ testMethodName+".png");
			System.out.println("HERE!!");
			try {
				FileUtils.copyFile(srcFiles,new File(filepath));
				System.out.println("Screenshot saved:" +filepath);
			}catch (IOException e)
			{
				e.printStackTrace();
			}
		}

}
