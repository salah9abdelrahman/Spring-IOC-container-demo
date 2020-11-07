package aopdemo.dao.services;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(boolean isExec){
        if(isExec){
            throw new RuntimeException("OOps Exception! :(");
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Heavy Traffic in cairo";
    }
}
