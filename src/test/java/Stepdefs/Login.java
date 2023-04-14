package Stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Map;

public class Login extends BaseTest implements Locators {
    @Given("User on homepage")
    public void userOnHomepage() {
        open(url);
    }

    @When("user login with data")
    public void userLoginWithData(DataTable table) {

        Map<String, String> loginInfo = table.asMap();

        $(xpath(loginInput,"Username")).sendKeys(loginInfo.get("username")).
        $(xpath(loginInput,"Password")).sendKeys(loginInfo.get("password")).
        $(xpath(loginButton)).click();
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        wait.until(ExpectedConditions.urlContains("inventory"));

    }
}
