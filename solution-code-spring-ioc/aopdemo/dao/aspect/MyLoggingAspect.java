package aopdemo.dao.aspect;

import aopdemo.dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

    private static final Logger logger = Logger.getLogger(MyLoggingAspect.class.getName());


    @Before("(aopdemo.dao.aspect.aopDeclarations.addAccount())")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("AddAccountAspect => beforeAddAccountAdvice");
        logger.info("methodSignature:  " + methodSignature);

        StringBuilder stringBuilder = new StringBuilder("args: ");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args
        ) {
            stringBuilder.append(arg).append(" | ");
        }
        logger.info(stringBuilder.toString());

    }

    @AfterReturning(pointcut = "(aopdemo.dao.aspect.aopDeclarations.findAccounts())",
            returning = "accounts")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> accounts) {
        String method = joinPoint.getSignature().toString();
        logger.info("executing @AfterReturning a method: " + method);

        if(!accounts.isEmpty()){
            accounts.get(0).setName("AHAHAHAHAHA!");
        }
        logger.info("result: " + accounts);
    }

    @AfterThrowing(pointcut = "aopdemo.dao.aspect.aopDeclarations.findAccounts()", throwing = "exc")
    public void afterThrowingFindAccount(JoinPoint joinPoint, Throwable exc){
        logger.info("@AfterThrowing -> signature:" + joinPoint.getSignature());
        logger.info("@AfterThrowing -> exec:" + exc);

    }


    @After("aopdemo.dao.aspect.aopDeclarations.findAccounts()")
    public void afterFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toString();
        logger.info("@after-FindAccountsAdvice: " + method);
    }

    @Around("aopdemo.dao.aspect.aopDeclarations.getTrafficFortune()")
    public Object aroundTrafficGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().toString();
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long duration = System.currentTimeMillis() - begin;
        logger.info("\nduration: " + duration);
        return result;
    }


}
