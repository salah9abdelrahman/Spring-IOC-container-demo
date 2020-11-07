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
}
