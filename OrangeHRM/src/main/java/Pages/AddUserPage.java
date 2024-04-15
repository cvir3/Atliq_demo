package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUserPage {
    public WebDriver driver;
    public AddUserPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By btnAdd = By.xpath("//a[@class='oxd-main-menu-item active']");

    public void clickOnAddButton()
    {
        driver.findElement((btnAdd)).click();
    }

}
