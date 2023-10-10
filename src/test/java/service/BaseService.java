package service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.PropertiesUtil;
import util.RequestManager;

import static io.restassured.RestAssured.given;

public class BaseService {

    protected PropertiesUtil propertiesUtil;

    public void setBaseURI(String baseURI){
        RequestManager.shared().setBaseURI(propertiesUtil.getPropertyByName(baseURI));
    }

    public Response doPostRequest(String resource, Object body) {
        return given()
                .spec(RequestManager.shared().getRequest())
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(resource);
    }

    public Response doGetRequest(String resource) {
        return given()
                .spec(RequestManager.shared().getRequest())
                .when()
                .get(resource);
    }

    public Response doPatchRequest(String resource, Object body) {
        return given()
                .spec(RequestManager.shared().getRequest())
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .patch(resource);
    }
}
