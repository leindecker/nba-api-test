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
    }

    @Then("I validate the return of the data according to the contract {string}")
    public void iValidateTheReturnOfTheDataAccordingToTheContract(String schemaPath) {
        RequestManager.shared().getResponse().then().body(matchesJsonSchemaInClasspath(ProjectSettings.API_CONTRACT_PATH + schemaPath));
    }

    @When("I create a new user with email already taken")
    public void iCreateANewUserWithEmailAlreadyTaken() {
        RequestManager.shared().setResponse(usersService.getUsers());
        String email = RequestManager.shared().getResponse().getBody().jsonPath().getString("email[0]");

        Users user = UsersDataFactory.createValidUser();
        user.setEmail(email);

        RequestManager.shared().setResponse(usersService.createUsers(user));
    }

    @When("I create a new user with empty name")
    public void iCreateANewUserWithEmptyName() {
        Users userEmptyName = UsersDataFactory.createUserWithEmptyName();
        RequestManager.shared().setResponse(usersService.createUsers(userEmptyName));
    }

    @When("I create a new user with empty email")
    public void iCreateANewUserWithEmptyEmail() {
        Users userEmptyEmail = UsersDataFactory.createUserWithEmptyEmail();
        RequestManager.shared().setResponse(usersService.createUsers(userEmptyEmail));
    }

    @When("I create a new user with empty gender")
    public void iCreateANewUserWithEmptyGender() {
        Users userEmptyGender = UsersDataFactory.createUserWithEmptyGender();
        RequestManager.shared().setResponse(usersService.createUsers(userEmptyGender));
    }

    @When("I create a new user with empty status")
    public void iCreateANewUserWithEmptyStatus() {
        Users userEmptyStatus = UsersDataFactory.createUserWithEmptyStatus();
        RequestManager.shared().setResponse(usersService.createUsers(userEmptyStatus));
    }
}
