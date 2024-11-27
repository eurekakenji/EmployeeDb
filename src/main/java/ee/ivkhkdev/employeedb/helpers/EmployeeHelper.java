package ee.ivkhkdev.employeedb.helpers;

import ee.ivkhkdev.employeedb.entity.Employee;
import ee.ivkhkdev.employeedb.input.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeHelper implements Helper<Employee>{
    @Autowired
    private Input input;
    @Override
    public Optional<Employee> create() {
        try {
            System.out.println("=== Employee creation ===");
            Employee employee = new Employee();
            System.out.print("First name: ");
            employee.setFirstName(input.nextLine());
            System.out.print("Last name: ");
            employee.setLastName(input.nextLine());
            System.out.print("Position: ");
            employee.setPosition(input.nextLine());
            System.out.print("Salary: ");
            employee.setSalary(input.nextLine());
            return Optional.of(employee);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public boolean printList(List<Employee> employees) {
        if(employees.isEmpty()){
            System.out.println("Employee list is empty");
            return false;
        }
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.printf("%d. %s %s. %s. %s%n",
                    i+1,
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getPosition(),
                    employee.getSalary()
            );
        }
        return true;
    }
}