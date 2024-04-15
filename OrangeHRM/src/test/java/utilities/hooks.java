package utilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class hooks {
    @Before("@AddUser")
    public void OrangeHRMLogin()
    {

    }
    @After("@User")
    public void UserManagement(){

    }
}
