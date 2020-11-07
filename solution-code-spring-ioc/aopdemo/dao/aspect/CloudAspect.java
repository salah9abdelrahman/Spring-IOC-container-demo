package aopdemo.dao.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudAspect {
    @Before("(aopdemo.dao.aspect.aopDeclarations.forDaoPackageNotGetterAndSetter())")
    public void logToCloud(){
        System.out.println("CloudAspect =>  logToCloud");

    }
}
