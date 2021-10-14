package FrameworkProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.Login;
import util.base;

import java.io.IOException;


public class HomePage extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    public WebDriver driver;

    @BeforeTest
    public void init() throws IOException {
        driver = initializeDriver();
    }

    @Test(dataProvider = "getData")
    public void homePage(String Username, String Password) throws IOException {
        driver.get(prop.getProperty("url"));
        LandingPage l = new LandingPage(driver);
        l.getLogin().click();

        Login lp = new Login(driver);
        System.out.println(Username);
        System.out.println(Password);
        lp.getEmail().sendKeys(Username);
        lp.getPassword().sendKeys(Password);
        // lp.getLogin().click();


    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @DataProvider
    Object[][] getData() {
        Object[][] data = new Object[1][2];  //need to check here to avoid array out of bound exception

        //0th row
        data[0][0] = "ajaywadkar1000@gmail.com";
        data[0][1] = "Admin@12345";


        return data;
    }

}
