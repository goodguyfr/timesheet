package timesheet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/ping")
public class PongController {
    @GetMapping("/api/ping")
    public String ping() {
        return "pong";
    }

}
