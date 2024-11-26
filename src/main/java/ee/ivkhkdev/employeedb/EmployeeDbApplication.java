package ee.ivkhkdev.employeedb;

import ee.ivkhkdev.employeedb.entity.Employee;
import ee.ivkhkdev.employeedb.input.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeDbApplication implements CommandLineRunner {

    @Autowired
    private Input input;
    private AppService<Employee> employeeService;
    public static void main(String[] args) {
        SpringApplication.run(EmployeeDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        boolean repeat = true;
        do {
            System.out.println("list of tasks:");
            System.out.println("0. exit program");
            System.out.println("1. Add employee to list");
            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    if(employeeService.add());


                default:
                    System.out.println("no such task number exists!");
            }
        }while(repeat);
        System.out.println("Goodbye");
    }

}
