package timesheet.demo.dto;

import lombok.Data;
import timesheet.demo.modelenum.CenterEnum;
import timesheet.demo.modelenum.WeekdayEnum;

import java.time.LocalDateTime;

@Data
public class CreateScheduleByEmployeeDTO {
    private WeekdayEnum weekdays;
    private CenterEnum place;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isLeaveJob;
    private String leaveReason;
}
