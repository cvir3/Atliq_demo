package webTestScripts;
import org.testng.annotations.*;
import utilities.baseClass;
import webFunctions.wf_UserManagement;
import webFunctions.wf_Login;

public class t_NS_UserManagement extends baseClass {
    @Test
    public void invalidUserManagement() throws InterruptedException {
        wf_Login wl = new wf_Login(webDriver);
        wf_UserManagement wa = new wf_UserManagement(webDriver);
        wl.loginFunction();
        wa.adminPage();
        wa.invalidAddUserDetails();
        webDriver.quit();
    }
}
