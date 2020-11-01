package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sports.properties")
//@ComponentScan("com.luv2code.springdemo")
@ComponentScan
public class ConfigurationDemo {

    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public FortuneService happyFortuneService() {
        return new HappyFortuneService();
    }
////
//    @Bean
//    SwimCoach swimCoach() {
//        return new SwimCoach(happyFortuneService());
//    }


}
