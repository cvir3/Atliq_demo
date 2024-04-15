package webFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.baseClass;
import webElements.we_UserManagement;

import java.time.Duration;
import java.util.List;


public class wf_UserManagement extends baseClass {
    WebDriver webDriver;
    we_UserManagement wa = new we_UserManagement();

    /* This is Constructor */
    public wf_UserManagement(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void adminPage() throws InterruptedException {
        WebElement clickable = webDriver.findElement(wa.selectAdmin);
        new Actions(webDriver).click(clickable).perform();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        WebElement addBtn = webDriver.findElement(wa.btnAdd);
        wait.until(ExpectedConditions.visibilityOf(addBtn));
        addBtn.click();
        String url = webDriver.getCurrentUrl();
        Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser");
        Thread.sleep(1000);
    }

    public void addUser() throws InterruptedException {
        webDriver.findElement(wa.clickOnUseRoleDw).click();
        webDriver.findElement(wa.selectItem).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement searchBox = webDriver.findElement(wa.inputEmpName);
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("James");
        Thread.sleep(3000);
        List<WebElement> list = webDriver.findElements(By.xpath("(//div[@role='listbox']//child::div)[3] "));
        System.out.println("Find Text::===>" + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains("Deion James Champlin")) {
                list.get(i).click();
            }
        }
        webDriver.findElement(wa.clickOnStatusDw).click();
        webDriver.findElement(wa.selectItem).click();
        webDriver.findElement(wa.inputUserName).sendKeys("JamesChamplin");
        webDriver.findElement(wa.inputPwd).sendKeys("Test@123");
        webDriver.findElement(wa.inputC_Pwd).sendKeys("Test@123");
        webDriver.findElement(wa.btnSave).submit();
        Thread.sleep(1000);
    }

    public void invalidAddUserDetails() throws InterruptedException {
        webDriver.findElement(wa.clickOnUseRoleDw).click();
        webDriver.findElement(wa.selectItem).click();
        webDriver.findElement(wa.inputEmpName).sendKeys("@#%$&!!@*#!");
        webDriver.findElement(By.xpath("//nav[@aria-label='Topbar Menu']//ul")).click();
        WebElement Invalidtext = webDriver.findElement(wa.txtInvalidEn);
        String expectedValue = Invalidtext.getText();
        String actualValue = "Invalid";
        Assert.assertEquals(expectedValue, actualValue);
        webDriver.findElement(wa.clickOnStatusDw).click();
        webDriver.findElement(wa.selectItem).click();
        webDriver.findElement(wa.inputUserName).sendKeys("DemoUser123");
        webDriver.findElement(wa.inputPwd).sendKeys("Test@123");
        webDriver.findElement(wa.inputC_Pwd).sendKeys("Test@1234");
        WebElement Invalid_Cpwd = webDriver.findElement(wa.txtInvalid_Cpwd);
        String expectedCpwd_Error = Invalid_Cpwd.getText();
        String actualCpwd_Error = "Passwords do not match.";
        Assert.assertEquals(expectedCpwd_Error, actualCpwd_Error);
        webDriver.findElement(wa.btnSave).submit();
    }
}
