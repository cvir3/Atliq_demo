package setpDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.baseClass;
import Pages.AddUserPage;

public class sd_AddUser {

    baseClass manager = new baseClass();
    WebDriver driver = manager.initializeDriver();
    AddUserPage au = new AddUserPage(driver);

    @Given("admin add the user")
    public void admin_add_the_user()
    {
        WebElement clickable = driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']"));
        new Actions(driver).clickAndHold(clickable).perform();
    }
    @When("click on the add button")
    public void click_on_the_add_button()
    {
        au.clickOnAddButton();
    }


}
