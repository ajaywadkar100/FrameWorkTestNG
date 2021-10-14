package FrameworkProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LandingPage;
import util.base;

import java.io.IOException;

public class validateNavbar extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    public WebDriver driver;

    @BeforeTest
    public void init() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void navigationBar() throws IOException {
        LandingPage l = new LandingPage(driver);
        Assert.assertTrue(l.getNavbar().isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
