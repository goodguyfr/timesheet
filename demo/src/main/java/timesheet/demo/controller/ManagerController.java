package timesheet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import timesheet.demo.dto.CreateManagerDTO;
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
}
