package data;

import model.Posts;
import model.PostsBuilder;
import net.datafaker.Faker;

public class PostsDataFactory {

    private static final Faker FAKER = new Faker();

    public static Posts createValidPost() {
        return newPost();
    }

    private static Posts newPost() {
        return new PostsBuilder()
                .title(FAKER.name().title())
                .body(FAKER.appliance().brand()).build();
    }
}
