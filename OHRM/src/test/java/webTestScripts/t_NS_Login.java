package webTestScripts;
import org.testng.annotations.*;
import utilities.baseClass;
import webFunctions.wf_Login;

import java.io.IOException;

public class t_NS_Login extends baseClass {

    @Test
    public void invalidLogin() throws InterruptedException {
        wf_Login wl = new wf_Login(webDriver);
        wl.invalidLoginFunction();
        webDriver.quit();
    }
}
