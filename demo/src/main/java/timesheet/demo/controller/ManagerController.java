package timesheet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timesheet.demo.dto.CreateManagerDTO;
import timesheet.demo.dto.DeleteEmployeeDTO;
import timesheet.demo.dto.DeleteManagerDTO;
import timesheet.demo.service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/api/timesheet/manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @PostMapping("/create")
    public void createUser(@RequestBody CreateManagerDTO dto) {
        managerService.createManager(dto);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable("id") String id, @RequestBody DeleteEmployeeDTO dto) {
        managerService.deleteEmployee(id, dto);
    }

    @DeleteMapping("/deleteManager/{id}")
    public void deleteManager(@PathVariable("id") String id, @RequestBody DeleteManagerDTO dto) {
        managerService.deleteManager(id, dto);
    }

//    @GetMapping("/findManager")
//    public List<User> findManager() {
//        return userService.findManager();
//    }
}
