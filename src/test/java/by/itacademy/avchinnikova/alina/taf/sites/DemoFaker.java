package by.itacademy.avchinnikova.alina.taf.sites;

import com.github.javafaker.Faker;

public class DemoFaker {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        System.out.println(email);
        String password = faker.internet().password();
        System.out.println(password);
        for (int i = 0; i < 10; i++) {
            String name = faker.name().name();
            System.out.println(name);
        }

    }
}
