package steps;

import data.PostsDataFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Posts;
import service.PostsService;
import util.RequestManager;

import java.io.IOException;

public class PostsSteps {

    private static final String JSON_PATH_ID = "id";
    private Integer userId;
    private Integer postId;
    private final PostsService postsService;

    public PostsSteps() throws IOException {
        postsService = new PostsService();
    }

    @When("I create a new post")
    public void iCreateANewPost() {
        userId = RequestManager.shared().getResponse().jsonPath().getInt(JSON_PATH_ID);
        Posts validPost = PostsDataFactory.createValidPost();
        RequestManager.shared().setResponse(postsService.createPost(validPost, userId));
    }

    @Then("I search all posts by user")
    public void iSearchAllPostsByUser() {
        userId = RequestManager.shared().getResponse().jsonPath().getInt("id");
        RequestManager.shared().setResponse(postsService.getPostsByUser(userId));
    }

    @Then("I delete the post")
    public void iDeleteThePost() {
        postId = RequestManager.shared().getResponse().jsonPath().getInt("id");
        RequestManager.shared().setResponse(postsService.deletePost(postId));
    }

}
