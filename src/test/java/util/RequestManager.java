package util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestManager {

    private static RequestManager sharedInstance;

    private RequestSpecification request;

    private Response response;

    private String profile;

    public static synchronized RequestManager shared() {
        if (sharedInstance == null) {
            sharedInstance = new RequestManager();
        }

        return sharedInstance;
    }

    public RequestSpecification getRequest() {
        if (request == null) {
            request = new RequestSpecBuilder().build();
        }

        return request;
    }

    public Response getResponse() {
        return response;
    }

    public void setRequest(final RequestSpecification request) {
        this.request = request;
    }

    public void setResponse(final Response response) {
        this.response = response;
    }

    public void setBaseURI(final String uri) {
        this.getRequest().baseUri(uri);
    }

    public void setHeaders(final Map<String, ?> header) {
        this.getRequest().headers(header);
    }

    public void teardownRequest() {
        this.request = null;
    }

    public void teardownRequestResponse() {
        this.response = null;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(final String profile) {
        if (profile == null || !profile.trim().equalsIgnoreCase("local")) {
            this.profile = "default";
        } else {
            this.profile = profile.trim().toUpperCase();
        }
    }

}
