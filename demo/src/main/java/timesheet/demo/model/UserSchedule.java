package timesheet.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import timesheet.demo.dto.CheckScheduleByManagerDTO;
import timesheet.demo.dto.CreateScheduleByEmployeeDTO;

import java.util.List;

@Data
@Document("schedule")
public class UserSchedule {
    @Id
    private String id;
    private String userId;
    List<CreateScheduleByEmployeeDTO> plan;
    List<CheckScheduleByManagerDTO> check;
}
