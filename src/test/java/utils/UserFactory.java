package utils;

import com.github.javafaker.Faker;
import utils.CRUD.User;

public class UserFactory {
    public static User createNewUser(){
        Faker faker = new Faker();
        return new User(
                faker.internet().emailAddress(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().password(),
                faker.address().fullAddress(),
                faker.address().city(),
                CommonMethods.randomNumAsString(5),
                faker.phoneNumber().cellPhone()
        );
    }
}
