package timesheet.demo.dto;

import lombok.Data;
import timesheet.demo.modelenum.BaseEnum;
import timesheet.demo.modelenum.WeekdayEnum;

import java.time.LocalDateTime;

@Data
public class CheckScheduleByManagerDTO {
    private WeekdayEnum weekdays;
    private BaseEnum place;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isLeaveJob;
    private String leaveReason;
    // Role manager
    private Boolean isConfirm;
    private String note;
    private LocalDateTime checkStartTime;
    private LocalDateTime checkEndTime;
}
