package aopdemo.dao;

import aopdemo.dao.services.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundMainDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);


        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain App AroundMainDemo");
        System.out.println("getFortune");
        String fortune = trafficFortuneService.getFortune();
        System.out.println("\nMy Fortune is " + fortune);
        System.out.println("Finished");
        context.close();
    }
}
