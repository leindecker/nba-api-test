package service;

import io.restassured.response.Response;
import model.Posts;
import util.PropertiesUtil;

import java.io.IOException;

public class PostsService extends BaseService {

    private static final String BASE_URI = "baseURI";

    private static final String POSTS_RESOURCE = "/posts/";

    private static final String USERS_RESOURCE = "/users/";

    public PostsService() throws IOException {
        propertiesUtil = new PropertiesUtil();
        setBaseURI(BASE_URI);
    }

    public Response createPost(Posts post, Integer userId) {
        return doPostRequest(USERS_RESOURCE + userId + POSTS_RESOURCE, post);
    }

    public Response getPostsByUser(Integer userId) {
        return doGetRequest(USERS_RESOURCE + userId + POSTS_RESOURCE);
    }

    public Response deletePost(Integer postId) {
        return doDeleteRequest(POSTS_RESOURCE + postId);
    }
}
