package timesheet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.demo.dto.*;
import timesheet.demo.exception.ExceedLimitException;
import timesheet.demo.exception.ResourceNotFoundException;
import timesheet.demo.model.User;
import timesheet.demo.model.UserSchedule;
import timesheet.demo.modelenum.WeekdayEnum;
import timesheet.demo.repository.ScheduleRepository;
import timesheet.demo.repository.UserRepository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    UserRepository userRepository;

    private ScheduleDTO toScheduleDTO(ScheduleDTO entity, CreateScheduleByEmployeeDTO dto) {
        entity.setPlace(dto.getPlace());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setIsLeaveJob(dto.getIsLeaveJob());
        entity.setLeaveReason(dto.getLeaveReason());
        entity.setWeekdays(dto.getWeekdays());

        return entity;
    }

    private String changeData(String data) {
        return data.replaceAll("\\$", "");
    }

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
            if (item.getStartTime() != null && item.getEndTime() != null) {
                Duration workTime = Duration.between(item.getStartTime(), item.getEndTime());
                int hour = (int) workTime.toMinutes() / 60;
                if (hour > 24) {
                    throw new ExceedLimitException(UserSchedule.class, hour);
                }
            }
        });

        dto.getCreatePlan().forEach(item -> {
            switch (item.getWeekdays()) {
                case MONDAY -> {
                    toScheduleDTO(monday, item);
                    monday.setWeekdays(WeekdayEnum.MONDAY);
                    scheduleDTO.add(monday);
                }
                case TUESDAY -> {
                    toScheduleDTO(tuesday, item);
                    tuesday.setWeekdays(WeekdayEnum.TUESDAY);
                    scheduleDTO.add(tuesday);
                }
                case WEDNESDAY -> {
                    toScheduleDTO(wednesday, item);
                    wednesday.setWeekdays(WeekdayEnum.WEDNESDAY);
                    scheduleDTO.add(wednesday);
                }
                case THURSDAY -> {
                    toScheduleDTO(thursday, item);
                    thursday.setWeekdays(WeekdayEnum.THURSDAY);
                    scheduleDTO.add(thursday);
                }
                case FRIDAY -> {
                    toScheduleDTO(friday, item);
                    friday.setWeekdays(WeekdayEnum.FRIDAY);
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
                if (dto.getIsConfirm()) {
                    item.setIsConfirm(true);
                } else {
                    item.setIsConfirm(false);
                    item.setNote(dto.getNote());
                    item.setCheckStartTime(dto.getCheckStartTime());
                    item.setCheckEndTime(dto.getCheckEndTime());
                }
            }
        });

        scheduleRepository.save(schedule);
    }

//    public List<UserSchedule> findAllSchedule() {
//        return scheduleRepository.findAll();
//    }

    public PayrollDTO payroll(String id) {
        UserSchedule schedule = scheduleRepository.findByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException(UserSchedule.class, id));

        PayrollDTO payrollDTO = new PayrollDTO();
        List<Integer> estimatedWorkingTime = new ArrayList<>();
        List<Integer> actualWorkingTime = new ArrayList<>();

        schedule.getPlan().forEach(item -> {
            if (item.getStartTime() != null && item.getEndTime() != null) {
                if (item.getIsConfirm()) {
                    Duration workTime = Duration.between(item.getStartTime(), item.getEndTime());
//                    int hours = (int) workTime.toHours();
                    Integer minutes = (int) workTime.toMinutes() / 60;
                    estimatedWorkingTime.add(minutes);
                    actualWorkingTime.add(minutes);

                } else {
                    Duration estimatedWorkTime = Duration.between(item.getStartTime(), item.getEndTime());
//                    int estimatedHours = (int) estimatedWorkTime.toHours();
                    Integer estimatedMinutes = (int) estimatedWorkTime.toMinutes() / 60;
                    estimatedWorkingTime.add(estimatedMinutes);

                    Duration actualWorkTime = Duration.between(item.getCheckStartTime(), item.getCheckEndTime());
//                    int actualHours = (int) actualWorkTime.toHours();
                    Integer actualMinutes = (int) actualWorkTime.toMinutes() / 60;
                    actualWorkingTime.add(actualMinutes);
                }
            }
        });

        payrollDTO.setEstimatedWorkingTime(estimatedWorkingTime);

        int estimatedTotalWorkingTime = estimatedWorkingTime.stream()
                .reduce(0, Integer::sum); // Tổng thời gian làm việc
        User estimated = userRepository.findById(schedule.getUserId()).orElseThrow(() -> new ResourceNotFoundException(User.class, id));
        int estimatedSalary = Integer.parseInt(changeData(estimated.getSalaryPerHour()));
        payrollDTO.setEstimatedSalary(estimatedTotalWorkingTime * estimatedSalary);

        payrollDTO.setActualWorkingTime(actualWorkingTime);

        int actualTotalWorkingTime = actualWorkingTime.stream().reduce(0, Integer::sum);
        User actual = userRepository.findById(schedule.getUserId()).orElseThrow(() -> new ResourceNotFoundException(User.class, id));
        int actualSalary = Integer.parseInt(changeData(actual.getSalaryPerHour()));
        payrollDTO.setActualSalary(actualTotalWorkingTime * actualSalary);

        return payrollDTO;
    }

}
