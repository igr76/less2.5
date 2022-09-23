import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("\employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("\add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName) throws EmployeeAlreadyAddedException {
        return employeeService.add(firstName,lastName);
    }
    @GetMapping("\find")
    public Employee find(@RequestParam String firstName,
                        @RequestParam String lastName) throws EmployeeNotFoundException {
        return employeeService.find(firstName,lastName);
    }
    @GetMapping("\remove")
    public Employee remove(@RequestParam String firstName,
                        @RequestParam String lastName) throws EmployeeNotFoundException {
        return employeeService.remove(firstName,lastName);
    }
    @GetMapping
    public List<Employee> findAll()  {
        return employeeService.findAll();
    }
}
