package webElements;
import org.openqa.selenium.By;

public class we_UserManagement {

    public By btnAdd = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    public By selectAdmin = By.xpath("//aside[@class='oxd-sidepanel']//li[1]");
    public By clickOnUseRoleDw = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
    public By selectItem = By.xpath("(//div[@role='listbox']//child::div)[3] ");
    public By inputEmpName = By.xpath("//input[@placeholder='Type for hints...']");
    public By inputUserName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    public By inputPwd = By.xpath("(//input[@type='password'])[1]");
    public By inputC_Pwd = By.xpath("(//input[@type='password'])[2]");
    public By clickOnStatusDw = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    public By btnSave = By.xpath("//button[normalize-space()='Save']");

    //AsertText Xpath
    public By txtInvalidEn = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
    public By txtInvalid_Cpwd = By.xpath("//span[normalize-space()='Passwords do not match']");


}
