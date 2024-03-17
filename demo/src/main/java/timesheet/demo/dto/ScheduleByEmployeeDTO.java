package timesheet.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ScheduleByEmployeeDTO {
    private String userId;
    List<CreateScheduleByEmployeeDTO> createPlan;
}
