package data;

import model.Users;
import model.UsersBuilder;
import net.datafaker.Faker;

public class UsersDataFactory {

    private static final Faker faker = new Faker();

    public static Users createValidUser() {
        return newUser();
    }

    private static Users newUser() {
        return new UsersBuilder().
                name(faker.name().firstName()).
                email(faker.internet().emailAddress()).
                gender("male").
                status("active").build();
    }

}
