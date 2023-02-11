package org.tms.racing_bets.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tms.racing_bets.domain.Horse;
import org.tms.racing_bets.domain.Pair;
import org.tms.racing_bets.domain.Rider;

@Configuration
public class AppConfig {

    @Bean
    Horse horse1() {
        return new Horse(new Faker());
    }

    @Bean
    Horse horse2() {
        return new Horse(new Faker());
    }

    @Bean
    Horse horse3() {
        return new Horse(new Faker());
    }

    @Bean
    Rider rider1() {
        return new Rider(new Faker());
    }

    @Bean
    Rider rider2() {
        return new Rider(new Faker());
    }

    @Bean
    Rider rider3() {
        return new Rider(new Faker());
    }

    @Bean
    Pair pair1() {
        return new Pair(horse1(), rider1(), 1);
    }

    @Bean
    Pair pair2() {
        return new Pair(horse2(), rider2(), 2);
    }

    @Bean
    Pair pair3() {
        return new Pair(horse3(), rider3(), 3);
    }
}