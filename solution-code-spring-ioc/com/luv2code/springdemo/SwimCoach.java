package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

    private final String email;

    private FortuneService fortuneService;

    public SwimCoach(@Qualifier("happyFortuneService") FortuneService fortuneService, @Value("${foo.email}") String email) {
        this.email = email;
        this.fortuneService = fortuneService;
        System.out.println("email");
        System.out.println(email);
    }


    @Override
    public String getDailyWorkout() {
        return "swim a lot";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
