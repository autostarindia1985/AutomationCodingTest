package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
      
    public static void takeScreenShot(WebDriver driver) throws IOException, InterruptedException
    {
    	File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
        File dest = new File("screenshots/" + filename);
        FileUtils.copyFile(scr, dest);
    }

   
}