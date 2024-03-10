package timesheet.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ScheduleDTO {
    private String userId;
    List<CreateScheduleByEmployeeDTO> plan;
    List<CheckScheduleByManagerDTO> check;
}
