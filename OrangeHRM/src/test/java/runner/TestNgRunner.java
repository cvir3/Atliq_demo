package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        glue = "setpDefinitions",
        tags = "@Login and @AddUser",
        plugin = {"html:target/cucumber-reports/cucumber-html-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestNgRunner extends AbstractTestNGCucumberTests{
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
