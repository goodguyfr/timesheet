package timesheet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timesheet.demo.dto.ScheduleDTO;
import timesheet.demo.service.ScheduleService;

@RestController
@RequestMapping("/api/timesheet/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/create")
    public void createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        scheduleService.createSchedule(scheduleDTO);
    }

}
