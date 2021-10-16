package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    private By signin = By.cssSelector("a[href*='sign_in']");
    private By title = By.cssSelector(".text-center>h2");
    private By navbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public Login getLogin()
    {
        driver.findElement(signin).click();
        Login lp = new Login(driver);
        return lp;
    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getNavbar() {
        return driver.findElement(navbar);
    }

}
