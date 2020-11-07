package aopdemo.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeforeMainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);


        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.setName("1");
        accountDAO.setServiceCode("1");

        accountDAO.addAccount(new Account(), true);
        accountDAO.getName();
        accountDAO.getServiceCode();
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        membershipDAO.addAccount();
        context.close();
    }
}
