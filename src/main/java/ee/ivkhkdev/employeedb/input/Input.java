package ee.ivkhkdev.employeedb.input;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public interface Input {
    default String nextLine(){
        return new Scanner(System.in).nextLine();
    }
}
