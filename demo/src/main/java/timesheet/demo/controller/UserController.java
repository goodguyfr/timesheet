package timesheet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import timesheet.demo.model.User;
import timesheet.demo.service.UserService;

@RestController
@RequestMapping("/api/timesheet/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public void createStaff(@RequestBody User employee) {
        userService.createUser(employee);
    }
}
