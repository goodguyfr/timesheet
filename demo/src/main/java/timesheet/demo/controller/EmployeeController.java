package timesheet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timesheet.demo.dto.AttachToManagerDTO;
import timesheet.demo.dto.CreateEmployeeDTO;
import timesheet.demo.dto.UpdateEmployeeDTO;
import timesheet.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/timesheet/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public void creatEmployee(@RequestBody CreateEmployeeDTO dto) {
        employeeService.createEmployee(dto);
    }

    @PutMapping("/attach-to-manager/{id}")
    public void updateIdByManager(@RequestBody AttachToManagerDTO dto, @PathVariable("id") String id) {
        employeeService.attachToManager(id, dto);
    }

    @PutMapping("/update/{id}")
    public void updateEmployee(@RequestBody UpdateEmployeeDTO dto, @PathVariable("id") String id) {
        employeeService.updateEmployee(dto, id);
    }

}
