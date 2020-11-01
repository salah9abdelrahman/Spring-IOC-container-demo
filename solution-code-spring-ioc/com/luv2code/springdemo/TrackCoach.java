package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;

public class TrackCoach implements Coach {

    private final FortuneService fortuneService;

    @Autowired
    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}










