package timesheet.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckScheduleByManagerDTO {
    private Boolean isConfirm;
    private String note;
    private LocalDateTime checkStartTime;
    private LocalDateTime checkEndTime;
}
