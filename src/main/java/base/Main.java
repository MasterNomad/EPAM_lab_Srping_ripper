package base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import base.config.AppConfig;
import base.quoter.IQuoter;

@ComponentScan
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        context.getBean(IQuoter.class).sayQuote();
    }

}
