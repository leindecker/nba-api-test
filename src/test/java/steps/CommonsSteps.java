package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import util.PropertiesUtil;
import util.RequestManager;

import java.io.IOException;
import java.util.Map;

public class CommonsSteps {

    private static final String AUTH_BEARER_TOKEN = "authentication.bearer_token";

    private final PropertiesUtil propertiesUtil;

    public CommonsSteps() throws IOException {
        propertiesUtil = new PropertiesUtil();
    }

    @Given("I have logged into the api")
    public void iHaveLoggedIntoTheApi() {
        RequestManager.shared().setHeaders(Map.of("Authorization", "Bearer " + propertiesUtil.getPropertyByName(AUTH_BEARER_TOKEN)));
    }

    @Then("I check the status code {int}")
    public void iCheckTheStatusCode(Integer statusCode) {
        RequestManager.shared().getResponse().then().statusCode(statusCode);
    }

    @Then("I validate the message {string} in {string} field")
    public void iValidateTheMessageInField(String message, String field) {
        String responseField = RequestManager.shared().getResponse().jsonPath().getString(field);
        Assert.assertEquals(message, responseField);
    }
}
