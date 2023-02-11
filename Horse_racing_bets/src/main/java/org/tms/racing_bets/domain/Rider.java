package org.tms.racing_bets.domain;

import com.github.javafaker.Faker;
import lombok.Data;

@Data
public class Rider {

    private Faker faker;
    private String name;

    public Rider(Faker faker) {
        this.faker = faker;
        this.name = faker.name().fullName();
    }

    public int getRandomSkillLevel() {
        return faker.random().nextInt(1, 10);
    }
}