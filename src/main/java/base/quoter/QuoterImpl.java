package base.quoter;

import base.annotation.InjectRandomInt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Component
public class QuoterImpl implements IQuoter {

    @InjectRandomInt(min = 2, max = 10)
    private int repeat;

    @Value("${message}")
    private String message;


    public QuoterImpl() {
        System.out.println("Phase 1");
        System.out.println("repeat=" + repeat + "\n");
    }

    @PostConstruct
    private void init() {
        System.out.println("Phase 2");
        System.out.println("repeat=" + repeat + "\n");
    }

    @Override
    public void sayQuote() {
        IntStream.range(0, repeat).forEach(i -> System.out.println(message));
    }
}
