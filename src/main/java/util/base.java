package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/data.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
/*
        if(browserName.equalsIgnoreCase("chrome"))
        {
            //execute in chrome driver
            System.out.println("I am insider if");
            System.setProperty("webdriver.chrome.driver" , "//Users//ajaywadkar//Documents//AjayWadkar//Automation//chromedriver");
            driver = new ChromeDriver();
            System.out.println("I have completed if");
        }

        else if (browserName.equals("firefox"))
        {
            //execute in firefox
        }
        System.out.println("I have skipped if");

 */

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //String destinationFile = System.getProperty("report/"+testCaseName+".png");
        FileUtils.copyFile(source, new File("report/"+testCaseName+".png"));
        //return destinationFile;
        File filepath=new File("report/"+testCaseName+".png");
        String destinationFile=filepath.getPath();
        return destinationFile;
    }
}
