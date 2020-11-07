package aopdemo.dao;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + " Doing my DB work HAHA! addAccount");
    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("setServiceCode");
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("No soup for you :)");
        }
        return Arrays.asList(new Account("bla", "blue"),
                new Account("said", "ahmed"),
                new Account("Medhat", "Abdo"));
    }


}
