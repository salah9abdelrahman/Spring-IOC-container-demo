package aopdemo.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningMainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);


        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("find accounts main: " + accounts);
        context.close();
    }
}

