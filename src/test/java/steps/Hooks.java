package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import util.RequestManager;

public class Hooks {

    private static final Integer PARAM_VALUE_CONN_TIMEOUT = 60000;

    private static final Integer PARAM_VALUE_SOCKET_TIMEOUT = 240000;

    @Before
    public void setUp() {
        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", PARAM_VALUE_CONN_TIMEOUT)
                        .setParam("http.socket.timeout", PARAM_VALUE_SOCKET_TIMEOUT));
        RestAssured.config = config;
    }

    @After
    public void teardown() {
        RequestManager.shared().teardownRequest();
        RequestManager.shared().teardownRequestResponse();
    }
}