package aopdemo.dao.aspect;

import aopdemo.dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

    @Before("(aopdemo.dao.aspect.aopDeclarations.addAccount())")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("AddAccountAspect => beforeAddAccountAdvice");
        System.out.println();
        System.out.println("methodSignature:  " + methodSignature);

        StringBuilder stringBuilder = new StringBuilder("args: ");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args
        ) {
            stringBuilder.append(arg).append(" | ");
        }
        System.out.println(stringBuilder);

    }

    @AfterReturning(pointcut = "(aopdemo.dao.aspect.aopDeclarations.findAccounts())", returning = "accounts")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> accounts) {
        String method = joinPoint.getSignature().toString();
        System.out.println("executing @AfterReturning a method: " + method);

        if(!accounts.isEmpty()){
            accounts.get(0).setName("AHAHAHAHAHA!");
        }
        System.out.println("result: " + accounts);
    }

    @AfterThrowing(pointcut = "aopdemo.dao.aspect.aopDeclarations.findAccounts()", throwing = "exc")
    public void afterThrowingFindAccount(JoinPoint joinPoint, Throwable exc){
        System.out.println("@AfterThrowing -> signature:" + joinPoint.getSignature());
        System.out.println("@AfterThrowing -> exec:" + exc);

    }


}
