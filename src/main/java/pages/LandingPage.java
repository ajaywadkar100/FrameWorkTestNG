package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    By signin = By.cssSelector("a[href*='sign_in']");
    By title = By.cssSelector(".text-center>h2");
    By navbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogin() {
        return driver.findElement(signin);
    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getNavbar() {
        return driver.findElement(navbar);
    }

}
