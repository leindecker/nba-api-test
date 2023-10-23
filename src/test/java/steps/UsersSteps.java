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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class UsersSteps {

    private Long id;

    private Users updatedUser;

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

    @When("I search for all the users")
    public void iSearchForAllTheUsers() {
        RequestManager.shared().setResponse(usersService.getUsers());
    }

    @When("I search for the user created")
    public void iSearchForTheUserCreated() {
        id = RequestManager.shared().getResponse().getBody().jsonPath().getLong("id");
        RequestManager.shared().setResponse(usersService.getUser(id));
    }

    @When("I search for invalid user")
    public void iSearchForInvalidUser() {
        id = UsersDataFactory.invalidId();
        RequestManager.shared().setResponse(usersService.getUser(id));
    }

    @When("I update user details")
    public void iUpdateUserDetails() {
        id = RequestManager.shared().getResponse().getBody().jsonPath().getLong("id");
        updatedUser = UsersDataFactory.createValidUser();
        updatedUser.setId(id);
        RequestManager.shared().setResponse(usersService.updateUserDetails(id, updatedUser));
    }

    @Then("I validate the user details updated")
    public void iValidateTheUserDetailsUpdated() {
        RequestManager.shared().setResponse(usersService.getUser(id));
        Users responseBody = RequestManager.shared().getResponse().getBody().as(Users.class);
        assertThat(updatedUser, samePropertyValuesAs(responseBody));
    }

}
