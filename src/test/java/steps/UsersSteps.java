package steps;

import data.UsersDataFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Users;
import service.UsersService;
import util.ProjectSettings;
import util.RequestManager;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsersSteps {

    private final UsersService usersService;

    public UsersSteps() throws IOException {
        usersService = new UsersService();
    }

    @When("I create a new user")
    public void iCreateANewUser() {
        Users validUser = UsersDataFactory.createValidUser();
        RequestManager.shared().setResponse(usersService.createUsers(validUser));
        System.out.println(RequestManager.shared().getResponse().getBody().asString());
    }

    @Then("I validate the return of the data according to the contract {string}")
    public void iValidateTheReturnOfTheDataAccordingToTheContract(String schemaPath) {
        RequestManager.shared().getResponse().then().body(matchesJsonSchemaInClasspath(ProjectSettings.API_CONTRACT_PATH + schemaPath));
    }

}
