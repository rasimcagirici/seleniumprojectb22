package com.cybertek.tests.day8_windows_javafaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1() {
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        System.out.println(fullName);
        String firstName = faker.name().firstName();
        System.out.println(firstName);
        String chuckNorris = faker.chuckNorris().fact();
        System.out.println(chuckNorris);
        String backToTheFuture = faker.backToTheFuture().quote();
        System.out.println(backToTheFuture);
        String gameOfThrones = faker.gameOfThrones().quote();
        System.out.println(gameOfThrones);
    }
}
