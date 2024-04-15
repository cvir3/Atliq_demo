package webTestScripts;
import org.testng.annotations.*;
import utilities.baseClass;
import webFunctions.wf_UserManagement;
import webFunctions.wf_Login;

public class t_PositiveScenarios extends baseClass {

    @Test
    public void validScenarios() throws InterruptedException{
        wf_Login wl = new wf_Login(webDriver);
        wf_UserManagement wa = new wf_UserManagement(webDriver);
        wl.loginFunction();
        wa.adminPage();
        wa.addUser();
        wl.logoutFunction();
        webDriver.quit();
    }
}
