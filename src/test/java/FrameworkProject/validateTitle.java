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

public class validateTitle extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    public WebDriver driver;

    @BeforeTest
    public void init() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void titleValidation() throws IOException {
        LandingPage l = new LandingPage(driver);
        Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSESss");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
