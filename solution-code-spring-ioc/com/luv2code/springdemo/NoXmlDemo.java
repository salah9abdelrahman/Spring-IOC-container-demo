package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoXmlDemo {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationDemo.class);
        Coach coach = context.getBean("swimCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

//        for (String beanName : context.getBeanDefinitionNames()) {
//            System.out.println(beanName);
//        }

        context.close();
    }
}
