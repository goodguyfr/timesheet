package timesheet.demo.dto;

import com.mongodb.lang.Nullable;
import lombok.Data;
import timesheet.demo.modelenum.BaseEnum;
import timesheet.demo.modelenum.WeekdayEnum;

import java.time.LocalDateTime;

@Data
public class ScheduleDTO {
    // Create schedule
    private WeekdayEnum weekdays;
    private BaseEnum place;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @Nullable
    private Boolean isLeaveJob;
    private String leaveReason;
    // Check schedule
    private Boolean isConfirm;
    private String note;
    private LocalDateTime checkStartTime;
    private LocalDateTime checkEndTime;
}
