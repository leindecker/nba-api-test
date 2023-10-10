package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import util.RequestManager;

import java.util.Optional;
import java.util.function.Predicate;

public class Hooks {

    private static final String PROFILE_ENV = "profile";
    private static final String DEFAULT_PROFILE = "local";

    @Before
    public void setUp() {
//        final var profile = Optional.ofNullable(System.getenv().get(PROFILE_ENV))
//                .filter(Predicate.not(String::isEmpty))
//                .orElse(DEFAULT_PROFILE);
//
//        System.out.println("SetUp: " + profile);
//
//        RequestManager.shared().setProfile(profile);

        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 60000)
                        .setParam("http.socket.timeout", 240000));
        RestAssured.config = config;
    }

    @After
    public void teardown() {
        RequestManager.shared().teardownRequest();
        RequestManager.shared().teardownRequestResponse();
    }
}
