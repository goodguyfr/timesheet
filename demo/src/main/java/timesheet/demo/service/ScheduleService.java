package timesheet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.demo.dto.ScheduleDTO;
import timesheet.demo.model.UserSchedule;
import timesheet.demo.repository.ScheduleRepository;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public void createSchedule(ScheduleDTO dto) {
        UserSchedule schedule = new UserSchedule();
        schedule.setUserId(dto.getUserId());
        schedule.setPlan(dto.getPlan());

        scheduleRepository.save(schedule);
    }

}
