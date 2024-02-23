package timesheet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timesheet.demo.dto.CreateManagerDTO;
import timesheet.demo.dto.DeleteEmployeeDTO;
import timesheet.demo.service.ManagerService;

@RestController
@RequestMapping("/api/timesheet/manager")
public class ManagerController {
    @Autowired
    ManagerService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody CreateManagerDTO dto) {
        userService.createManager(dto);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable("id") String id, @RequestBody DeleteEmployeeDTO dto) {
        userService.deleteEmployee(id, dto);
    }
}
