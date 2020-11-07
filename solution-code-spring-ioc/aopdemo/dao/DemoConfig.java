package aopdemo.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//Spring AOP proxy support
@EnableAspectJAutoProxy
@ComponentScan("aopdemo")
public class DemoConfig {
}
