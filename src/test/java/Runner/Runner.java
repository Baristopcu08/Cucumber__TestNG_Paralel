package Runner;

import driver.Browsers;
import driver.Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


@CucumberOptions(
        features = {"src/test/java/Features/features_1.feature"},
        glue = {"Stepdefs"}


)
public class Runner extends AbstractTestNGCucumberTests {


    @BeforeTest
    @Parameters("browser")
    public  void beforeTest( @Optional String browser){
        Driver.getDriver(Browsers.valueOf(browser));

    }
}
