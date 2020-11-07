package aopdemo.dao.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class AddAccountAspect {

    @Before("(aopdemo.dao.aspect.aopDeclarations.forDaoPackageNotGetterAndSetter())")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("AddAccountAspect => beforeAddAccountAdvice");
        System.out.println();
        System.out.println("methodSignature:  " + methodSignature);

        StringBuilder stringBuilder = new StringBuilder("args: ");
        Object[] args = joinPoint.getArgs();
        for (Object arg: args
             ) {
            stringBuilder.append(arg).append(" | ");
        }
        System.out.println(stringBuilder);

    }


}
