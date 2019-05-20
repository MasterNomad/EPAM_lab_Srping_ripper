package base.quoter;

import base.annotation.InjectRandomInt;
import base.annotation.Profiling;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Component
@Profiling
public class Quoter implements IQuoter {

    @InjectRandomInt(min = 2, max = 5)
    private int repeat;

    @Value("${message}")
    private String message;


    public Quoter() {
        System.out.println("Constructor:");
        System.out.println("repeat=" + repeat);
        System.out.println();
    }

    @PostConstruct
    private void init() {
        System.out.println("PostConstruct:");
        System.out.println("repeat=" + repeat);
        System.out.println();
    }

    @Override
    public void sayQuote() {
        IntStream.range(0, repeat).forEach(i -> System.out.println(message));
        System.out.println();
    }
}
