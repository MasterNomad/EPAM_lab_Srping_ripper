package base;

import base.config.AppConfig;
import base.quoter.IQuoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        while (true) {
            Thread.sleep(1000);
            context.getBean(IQuoter.class).sayQuote();
        }
    }

}
