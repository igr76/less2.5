import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.SIZE;

@Service
public class EmployeeService {
    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= SIZE) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;


    }
    public Employee remove(String firstName, String lastName)  {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
           employees.remove(employee);
           return employee;
        } throw new EmployeeNotFoundException();


    }
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } throw new EmployeeNotFoundException();


    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }
}
