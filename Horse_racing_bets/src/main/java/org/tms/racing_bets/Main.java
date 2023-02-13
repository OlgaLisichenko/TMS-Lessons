package org.tms.racing_bets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tms.racing_bets.service.BetsService;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BetsService bean = context.getBean(BetsService.class);
        bean.makeBet();
    }
}