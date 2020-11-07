package aopdemo.dao;

import aopdemo.dao.services.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundMainWithLoggerDemo {
    private static final Logger logger = Logger.getLogger(AroundMainWithLoggerDemo.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);


        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("Main App AroundMainDemo");
        logger.info("getFortune");
        try {

            String fortune = trafficFortuneService.getFortune(true);
            logger.info("My Fortune is " + fortune);
        } catch (RuntimeException e){

        }
        logger.info("Finished");
        context.close();
    }
}
