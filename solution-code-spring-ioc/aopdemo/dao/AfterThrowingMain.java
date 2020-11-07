package aopdemo.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);


        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;
        try {
            accounts = accountDAO.findAccounts(true);
        } catch (Exception e){
            System.out.println("main exce: " + e);
        }

        System.out.println("find accounts main: " + accounts);
        context.close();
    }
}
