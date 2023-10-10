package service;

import io.restassured.response.Response;
import model.Users;
import util.PropertiesUtil;

import java.io.IOException;

public class UsersService extends BaseService{

    private static final String BASE_URI = "baseURI";

    private static final String USERS_RESOURCE = "/users";

    public UsersService() throws IOException {
        propertiesUtil = new PropertiesUtil();
        setBaseURI(BASE_URI);
    }

    public Response createUsers(Users users) {
        return doPostRequest(USERS_RESOURCE, users);
    }

    public Response getUsers() {
        return doGetRequest(USERS_RESOURCE);
    }
}
