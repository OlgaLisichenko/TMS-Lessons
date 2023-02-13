package org.tms.racing_bets.domain;

import com.github.javafaker.Faker;
import lombok.Data;

@Data
public class Horse {

    private Faker faker;
    private String name;

    public Horse(Faker faker) {
        this.faker = faker;
        this.name = faker.cat().name();
    }

    public int getRandomSpeed() {
        return faker.random().nextInt(1, 10);
    }
}