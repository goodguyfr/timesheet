package timesheet.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/ping")
public class PongController {
    @GetMapping("/api/ping")
    public String ping() {
        return "pong";
    }

}
