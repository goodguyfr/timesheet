package timesheet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import timesheet.demo.model.Employee;
import timesheet.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/timesheet/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }
}
