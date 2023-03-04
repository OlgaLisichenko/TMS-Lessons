package org.tms.racing_bets;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.tms.racing_bets.service.BetsService;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext("org.tms.racing_bets");
        BetsService bean = context.getBean(BetsService.class);
        bean.makeBet();
    }
}