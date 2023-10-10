package data;

import model.Users;
import model.UsersBuilder;
import net.datafaker.Faker;
import org.apache.maven.surefire.shared.lang3.StringUtils;

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

    public static Users createUserWithEmptyName() {
        Users userWithEmptyName = newUser();
        userWithEmptyName.setName(StringUtils.EMPTY);

        return userWithEmptyName;
    }

    public static Users createUserWithEmptyEmail() {
        Users userWithEmptyEmail = newUser();
        userWithEmptyEmail.setEmail(StringUtils.EMPTY);

        return userWithEmptyEmail;
    }

    public static Users createUserWithEmptyGender() {
        Users userWithEmptyGender = newUser();
        userWithEmptyGender.setGender(StringUtils.EMPTY);

        return userWithEmptyGender;
    }

    public static Users createUserWithEmptyStatus() {
        Users userWithEmptyStatus = newUser();
        userWithEmptyStatus.setStatus(StringUtils.EMPTY);

        return userWithEmptyStatus;
    }

    public static Long invalidId() {
        return (long) faker.number().numberBetween(7000, 8499);
    }

}
