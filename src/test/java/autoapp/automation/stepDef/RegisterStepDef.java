package autoapp.automation.stepDef;

import autoapp.automation.pages.PersonalInfoPage;
import autoapp.automation.pages.RegisterPage;
import autoapp.automation.utility.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;

public class RegisterStepDef extends BaseUtil {

    private BaseUtil baseUtil;
    private PersonalInfoPage personalInfoPage;
    private RegisterPage registerPage;
    private RequestSpecification request = RestAssured.given();
    private Response response;

    public RegisterStepDef(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
        registerPage = new RegisterPage(baseUtil);
        personalInfoPage = new PersonalInfoPage(baseUtil);
    }

    @Given("^Automation practice application is opened$")
    public void automation_practice_application_is_opened() throws Throwable {
        registerPage.openApplicaiton();
        response =
                request.baseUri("https://gorest.co.in/")
                        .basePath("public-api/users")
                        .log().all()
                        .when()
                        .get();
    }

    @When("^I click sign in$")
    public void i_click_sign_in() throws Throwable {
        registerPage.clickSignIn();
        response.then().log().all();
    }

    @And("^I create account with emailid \"([^\"]*)\"$")
    public void i_create_account_with_emailid(String emailId) throws Throwable {
        registerPage.createAccount(emailId);
        Thread.sleep(5000);
    }


    @Then("^I should be able to register with my below details$")
    public void i_should_be_able_to_register_with_my_below_details(DataTable dataTable) throws Throwable {
        personalInfoPage.enterPersonalInformation(dataTable);
        Thread.sleep(5000);
    }
}
