package data;

import model.Users;
import model.UsersBuilder;
import net.datafaker.Faker;
import org.apache.maven.surefire.shared.lang3.StringUtils;

public class UsersDataFactory {

    private static final int SEVEN_THOUSAND_NUMBER = 7000;

    private static final int EIGHT_THOUSAND_FIVE_HUNDRED_NUMBER = 8500;

    private static final Faker FAKER = new Faker();

    public static Users createValidUser() {
        return newUser();
    }

    private static Users newUser() {
        return new UsersBuilder()
                .name(FAKER.name().firstName())
                .email(FAKER.internet().emailAddress())
                .gender("male")
                .status("active").build();
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
        return (long) FAKER.number().numberBetween(SEVEN_THOUSAND_NUMBER, EIGHT_THOUSAND_FIVE_HUNDRED_NUMBER);
    }
}
