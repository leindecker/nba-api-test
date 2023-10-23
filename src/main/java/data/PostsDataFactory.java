package data;

import model.Posts;
import model.PostsBuilder;
import net.datafaker.Faker;

public class PostsDataFactory {

    private static final Faker faker = new Faker();

    public static Posts createValidPost() {
        return newPost();
    }

    private static Posts newPost() {
        return new PostsBuilder().
                title(faker.name().title()).
                body(faker.appliance().brand()).build();
    }
}
