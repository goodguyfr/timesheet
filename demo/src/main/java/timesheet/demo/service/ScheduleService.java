package timesheet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.demo.dto.CheckScheduleByManagerDTO;
import timesheet.demo.dto.ScheduleByEmployeeDTO;
import timesheet.demo.dto.ScheduleDTO;
import timesheet.demo.exception.ResourceNotFoundException;
import timesheet.demo.model.UserSchedule;
import timesheet.demo.modelenum.WeekdayEnum;
import timesheet.demo.repository.ScheduleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public void createSchedule(ScheduleByEmployeeDTO dto) {
        UserSchedule schedule = new UserSchedule();
        schedule.setUserId(dto.getUserId());
        List<ScheduleDTO> scheduleDTO = new ArrayList<>();
        ScheduleDTO monday = new ScheduleDTO();
        ScheduleDTO tuesday = new ScheduleDTO();
        ScheduleDTO wednesday = new ScheduleDTO();
        ScheduleDTO thursday = new ScheduleDTO();
        ScheduleDTO friday = new ScheduleDTO();

        dto.getCreatePlan().forEach(item -> {
            switch (item.getWeekdays()) {
                case MONDAY -> {
                    monday.setWeekdays(WeekdayEnum.MONDAY);
                    monday.setPlace(item.getPlace());
                    monday.setStartTime(item.getStartTime());
                    monday.setEndTime(item.getEndTime());
                    monday.setIsLeaveJob(item.getIsLeaveJob());
                    monday.setLeaveReason(item.getLeaveReason());

                    scheduleDTO.add(monday);
                }
                case TUESDAY -> {
                    tuesday.setWeekdays(WeekdayEnum.TUESDAY);
                    tuesday.setPlace(item.getPlace());
                    tuesday.setStartTime(item.getStartTime());
                    tuesday.setEndTime(item.getEndTime());
                    tuesday.setIsLeaveJob(item.getIsLeaveJob());
                    tuesday.setLeaveReason(item.getLeaveReason());

                    scheduleDTO.add(tuesday);
                }
                case WEDNESDAY -> {
                    wednesday.setWeekdays(WeekdayEnum.WEDNESDAY);
                    wednesday.setPlace(item.getPlace());
                    wednesday.setStartTime(item.getStartTime());
                    wednesday.setEndTime(item.getEndTime());
                    wednesday.setIsLeaveJob(item.getIsLeaveJob());
                    wednesday.setLeaveReason(item.getLeaveReason());

                    scheduleDTO.add(wednesday);
                }
                case THURSDAY -> {
                    thursday.setWeekdays(WeekdayEnum.THURSDAY);
                    thursday.setPlace(item.getPlace());
                    thursday.setStartTime(item.getStartTime());
                    thursday.setEndTime(item.getEndTime());
                    thursday.setIsLeaveJob(item.getIsLeaveJob());
                    thursday.setLeaveReason(item.getLeaveReason());

                    scheduleDTO.add(thursday);
                }
                case FRIDAY -> {
                    friday.setWeekdays(WeekdayEnum.FRIDAY);
                    friday.setPlace(item.getPlace());
                    friday.setStartTime(item.getStartTime());
                    friday.setEndTime(item.getEndTime());
                    friday.setIsLeaveJob(item.getIsLeaveJob());
                    friday.setLeaveReason(item.getLeaveReason());

                    scheduleDTO.add(friday);
                }
            }
        });

        schedule.setPlan(scheduleDTO);
        scheduleRepository.save(schedule);
    }

    public void checkScheduleByManager(String id, CheckScheduleByManagerDTO dto, WeekdayEnum weekdays) {
        UserSchedule schedule = scheduleRepository.findByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException(UserSchedule.class, dto));
        schedule.getPlan().forEach(item -> {
            if (weekdays.equals(item.getWeekdays())) {
                if (!dto.getIsConfirm()) {
                    item.setIsConfirm(false);
                    item.setNote(dto.getNote());
                    item.setCheckStartTime(dto.getCheckStartTime());
                    item.setCheckEndTime(dto.getCheckEndTime());
                } else {
                    item.setIsConfirm(true);
                }
            }
        });

        scheduleRepository.save(schedule);
    }

//    public List<UserSchedule> findAllSchedule() {
//        return scheduleRepository.findAll();
//    }

}
