package timesheet.demo.dto;

import lombok.Data;
import timesheet.demo.modelenum.BaseEnum;
import timesheet.demo.modelenum.WeekdayEnum;

import java.time.LocalDateTime;

@Data
public class CheckScheduleByManagerDTO {
    // Role manager
    private WeekdayEnum weekdays;
    private BaseEnum place;
    private Boolean isLeaveJob;
    private String leaveReason;
    private Boolean isConfirm;
    private String note;
    private LocalDateTime checkStartTime;
    private LocalDateTime checkEndTime;
}
