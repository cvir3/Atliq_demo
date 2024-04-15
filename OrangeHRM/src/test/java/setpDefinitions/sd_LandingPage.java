package setpDefinitions;

import Pages.AddUserPage;
import Pages.LandingPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.baseClass;

import java.io.IOException;

public class sd_LandingPage {
    //Objects
    baseClass manager = new baseClass();
    WebDriver driver = manager.initializeDriver();
    LandingPage lp = new LandingPage(driver);
    AddUserPage au = new AddUserPage(driver);


    @Given("launch chrome browser {string}")
    public void launch_chrome_browser(String loginUrl) {
        manager.openPage(loginUrl);
    }

    @When("user login into webapp with {string} and password {string}")
    public void user_login_into_webapp_with_and_password(String Username, String Password) throws InterruptedException {
        lp.enterUsername(Username);
        lp.enterPassword(Password);
        lp.clickOnLogin();
        Thread.sleep(4000);
    }

    @Then("user navigate to dashboard")
    public void user_navigate_to_dashboard() {
        String url = manager.getCurrentPageUrl();
        Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }



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


    @Then("close browser")
    public void close_browser() {
        manager.tearDown();
    }

    @AfterStep
    public void result(Scenario scenario)
    {
        String scenarioName = scenario.getName();
        if(scenario.isFailed())
        {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenarioName);
        }
    }


}
