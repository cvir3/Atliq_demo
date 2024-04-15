package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;
    //Constructor
    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
    }
    By inputUserName = By.xpath("//input[@name='username']");
    By inputPassword = By.xpath("//input[@name='password']");
    By btnLogin = By.xpath("//button[normalize-space()='Login']");


    public void enterUsername(String UserName)
    {
        driver.findElement(inputUserName).sendKeys(UserName);
    }
    public void enterPassword(String Password)
    {
        driver.findElement(inputPassword).sendKeys(Password);
    }
    public void clickOnLogin()
    {
        driver.findElement(btnLogin).click();
    }

}

