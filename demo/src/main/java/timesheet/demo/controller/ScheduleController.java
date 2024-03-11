package timesheet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timesheet.demo.dto.CheckScheduleByManagerDTO;
import timesheet.demo.dto.ScheduleByEmployeeDTO;
import timesheet.demo.modelenum.WeekdayEnum;
import timesheet.demo.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api/timesheet/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/create")
    public void createSchedule(@RequestBody ScheduleByEmployeeDTO scheduleDTO) {
        scheduleService.createSchedule(scheduleDTO);
    }

    @PutMapping("/confirm-by-manager/{id}")
    public void checkScheduleByManager(@PathVariable("id")String id, @RequestBody CheckScheduleByManagerDTO dto,
                                       @RequestParam WeekdayEnum weekdays) {
        scheduleService.checkScheduleByManager(id, dto, weekdays);
    }

//    @GetMapping("/find-all-schedule")
//    public List<UserSchedule> findAllSchedule() {
//        return scheduleService.findAllSchedule();
//    }

}


