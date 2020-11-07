package aopdemo.dao.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class aopDeclarations {
    @Pointcut("execution(* aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* aopdemo.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* aopdemo.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNotGetterAndSetter(){}

    @Pointcut("execution (* aopdemo.dao.AccountDAO.addAccount(..))")
    public void addAccount(){}

    @Pointcut("execution (* aopdemo.dao.AccountDAO.findAccounts(..))")
    public void findAccounts(){}

    @Pointcut("execution (* aopdemo.dao.services.TrafficFortuneService.getFortune(..))")
    public void getTrafficFortune(){}
}
