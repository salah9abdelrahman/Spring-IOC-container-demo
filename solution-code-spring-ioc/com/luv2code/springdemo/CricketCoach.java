package com.luv2code.springdemo;

public class CricketCoach implements Coach {

    private String emailAddress;
    private String team;
    private  FortuneService fortuneService;


    public CricketCoach() {
        System.out.println("CricketCoach constructor");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "practice fast for 15 mins";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach setFortuneService");
        this.fortuneService = fortuneService;
    }
}
