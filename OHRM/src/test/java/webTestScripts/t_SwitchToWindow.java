package webTestScripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class t_SwitchToWindow {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(500);

        String parentWindowId = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']")).click();

        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']")).click();
        driver.findElement(By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']")).click();
        driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']")).click();

        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if (switchToRightWindow("Facebook", hList)) {
            System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
        }
        closeAllTabs(hList, parentWindowId);
        switchToParentWindow(parentWindowId);
        System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
    }

    //for parent window
    public static void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    public static void closeAllTabs(List<String> hList, String parentWindowId) {
        for (String e : hList) {
            if (!e.equals(parentWindowId)) {
                driver.switchTo().window(e).close();
            }
        }
    }

    public static boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String e : hList) {
            String title = driver.switchTo().window(e).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window...");
                return true;
            }
        }
        return false;
    }
    //Scenario: - Open new tab and move to parent tab
//    public static void parentToChildTab() throws InterruptedException{
//        /*Put this code behind the static WebDriver driver; */
//        Set<String> w;
//        /* Put this code behind the driver=new ChromeDriver();*/
//        //w = driver.getWindowHandles();
//        // Also this code shoudl be add in this class.
//        w = driver.getWindowHandles();
//        Iterator<String> t = w.iterator();
//        String ch = t.next();
//        String pw = t.next();
//        driver.switchTo().window(ch);
//        driver.switchTo().window(pw);
//        Thread.sleep(2000);
     //Note:- call this method when evere you want to user just call it.
//    }
}
