package pageObjects;

import java.time.Duration; // Import Duration

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    // WebDriver instance from BasePage constructor
    private WebDriverWait wait; // Declare WebDriverWait

    public HomePage(WebDriver driver) {
        super(driver);
        // Initialize WebDriverWait in the constructor
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased timeout to 15 seconds for robustness
    }

    @FindBy(xpath="//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement lnkRegister;

    @FindBy(linkText = "Login")
    WebElement linkLogin;


    public void clickMyAccount() {
        // Wait until the 'My Account' link is visible and clickable
        wait.until(ExpectedConditions.elementToBeClickable(lnkMyaccount)).click();
    }

    public void clickRegister() {
        // Wait until the 'Register' link is visible and clickable
        wait.until(ExpectedConditions.elementToBeClickable(lnkRegister)).click();
    }

    public void clickLogin() {
        // Wait until the 'Login' link is visible and clickable
        wait.until(ExpectedConditions.elementToBeClickable(linkLogin)).click();
    }
}